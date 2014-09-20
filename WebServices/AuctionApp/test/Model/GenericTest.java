/*
 */

package Model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @param <ClassTested> 
 * @author education@oracle.com
 */
public class GenericTest<ClassTested extends DomainEntity> {
  protected static EntityManagerFactory emf = null;
  protected EntityManager em = null;
  protected EntityTransaction tx = null;

  protected ClassTested testObject = null;
  private byte[] marshalledTestObj;
  private Class<ClassTested> testedClass = null;
  protected long testObjectId = 0;

  private Map<String,byte[]> paramsNeeded = null;
  protected Map<String,DomainEntity> params = null;


  public GenericTest() {}

  public GenericTest(Map<String,DomainEntity> params) {
    paramsNeeded = new HashMap<String,byte[]>();
    for( String key : params.keySet() ) {
      paramsNeeded.put(key, marshallObject(params.get(key)));
    }
  }
  
  public GenericTest( ClassTested obj ) {
    marshalledTestObj = marshallObject( obj );
  }

  public void beginTransaction() {
    tx.begin();
    if (paramsNeeded != null) refreshParams();
  }
  public void commitTransaction() {
    tx.commit();
  }
  public void rollbackTransaction() {
    tx.rollback();
  }

  private byte[] marshallObject( Object obj ) {
    byte[] marshalledObj = null;
    try {
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      ObjectOutputStream oos = new ObjectOutputStream( bos );
      oos.writeObject( obj );
      oos.flush();
      marshalledObj = bos.toByteArray();
      oos.close();
    } catch(IOException ex ) {
      System.out.println(ex);
    }
    return marshalledObj;
  }

  private DomainEntity unmarshallObject(byte[] obj) {
    try {
      ByteArrayInputStream bis = new ByteArrayInputStream(obj);
      ObjectInputStream ois = new ObjectInputStream(bis);
      DomainEntity result = (DomainEntity) ois.readObject();
      return result;
    } catch(Exception ex) {
      System.out.println("Unmarshalling: exception: " + ex );
      return null;
    }
  }

  protected ClassTested createTestObject() {
    if (marshalledTestObj == null) return null;
    try {
      ByteArrayInputStream bis =
        new ByteArrayInputStream(marshalledTestObj);
      ObjectInputStream ois = new ObjectInputStream(bis);
      return (ClassTested) ois.readObject();
    } catch(Exception ex) {
      return null;
    }
  }

  @Before
  public void setUp() {
    em = emf.createEntityManager();
    tx = em.getTransaction();
    try {
      tx.begin();
      if (marshalledTestObj != null) {
        setUpSingleTestObject();
      } else {
        setUpParameters();
      }
    } finally {
      tx.commit();
      if (testedClass != null) {
        testObjectId = testObject.getId();
      }
    }
  }

  private void setUpParameters() {
    params = new HashMap<String,DomainEntity>();
    for ( String key : paramsNeeded.keySet() ) {
      byte[] marshalledObj = paramsNeeded.get(key);
      DomainEntity value = unmarshallObject(marshalledObj);
      em.persist(value);
      params.put(key,value);
    }
  }

  private void refreshParams() {
    for ( String key: params.keySet() ) {
      DomainEntity target = params.get(key);
      params.put(key,em.find(target.getClass(), target.getId()));
    }
  }

  private void setUpSingleTestObject() {
    testObject = createTestObject();
    if (testObject != null) {
      em.persist( testObject );
      testedClass = (Class<ClassTested>) testObject.getClass();
    }
  }

  @After
  public void tearDown() {
    if (testedClass != null) {
      try {
        if (tx.isActive()) 
        { tx.rollback(); }
        tx.begin();
        ClassTested target = em.find(testedClass, testObjectId);
        if (target != null) 
        { em.remove(target); }
      } finally {
        tx.commit();
      }
    } else {
      tx.begin();
      for ( DomainEntity value : params.values() ) {
        try { em.remove(em.find(value.getClass(), value.getId())); }
        catch( Exception ex ) {
          System.out.println("tearDown: " + ex);
        }
      }
      tx.commit();
    }
    if (em != null) {
      tx = null;
      em.close();
    }
  }

  @BeforeClass
  public static void setUpFactory() {
    if (emf == null) {
      // Use persistence.xml configuration
      emf = Persistence.createEntityManagerFactory("AuctionAppPU");
      Assert.assertNotNull( emf );
    }
  }

  @AfterClass
  public static void shutdown() {
    // cannot close here - if running a suite with more than one test,
    // closing the EMF here will mean that the first test class
    // in the test suite will succeed - but all the others that follow
    // will fail, since the EMF will not be there any more...
    //
    // if (emf != null) emf.close();
  }

  @Test
  public void testConfiguration() {
    log( "testConfiguration" );
    Assert.assertNotNull( emf );
    Assert.assertNotNull( em );
  }

  @Test
  public void testGetId() {
    log( "getId" );

    if (testedClass != null) {
      tx.begin();
      DomainEntity instance = em.find( testedClass, testObjectId );
      long result = instance.getId();
      tx.commit();
      Assert.assertEquals( result, testObjectId );
    }
  }

  public void log( String message ) {
    System.out.println( message );
  }

  public void dumpTable( String tableName ) {
    try {
      Connection c =
        DriverManager.getConnection( "jdbc:derby://localhost/auction",
                                     "auction", "auction" );
      Statement s = c.createStatement();
      ResultSet rs = s.executeQuery( "SELECT * FROM " + tableName );
      int numColumns = rs.getMetaData().getColumnCount();
      for ( int i = 0; i < numColumns; i++ ) {
        System.out.printf( "%12s", rs.getMetaData().getColumnName( i+1));
      }
      System.out.println();
      while (rs.next()) {
        for ( int i = 0; i < numColumns; i++ ) {
          System.out.printf( "%12s", rs.getString(i+1) );
        }
        System.out.println();
      }
    } catch( SQLException ex ) {
      ex.printStackTrace();
    }
  }
}
