/*
 */

package Model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author education@oracle.com
 */
public class UserTest extends GenericTest<User>{

    private static final String EXPECTED_NAME = "Tracy Admin";
    private static final String NEW_NAME = "Kelly User";
    private static final String EXPECTED_EMAIL = "tracy@example.com";
    private static final String NEW_EMAIL = "kelly@example.com";

    private static final String EXPECTED_ITEM_DESC = "Item Description";
    private static final Item EXPECTED_ITEM = new Item(EXPECTED_ITEM_DESC);

    @BeforeClass
    public static void initialize() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(EXPECTED_ITEM);
        tx.commit();
        em.close();
    }

    @After
    public void tearDown() {
        tx = em.getTransaction();
        tx.begin();
        User instance = em.find(User.class, testObjectId);
        instance.setAuctions(Collections.<Auction>emptyList());
        instance.setBids(Collections.<Bid>emptyList());
        tx.commit();
    }

    public UserTest() {
        super( new User(EXPECTED_NAME,EXPECTED_EMAIL) );
    }

    /**
     * Test of getAuctions method, of class User.
     */
    @Test
    public void testGetAuctions() {
        System.out.println("getAuctions");

        tx = em.getTransaction();
        tx.begin();
        User instance = em.find(User.class, testObjectId);
        List<Auction> result = instance.getAuctions();
        tx.commit();
        assertEquals(result.size(),0);
    }

    /**
     * Test of setAuctions method, of class User.
     */
    @Test
    public void testSetAuctions() {
        System.out.println("setAuctions");

        tx = em.getTransaction();
        tx.begin();
        User instance = em.find(User.class, testObjectId);

        Auction anAuction = new SimpleAuction(instance,EXPECTED_ITEM,5,1.0);
        List<Auction> auctions = Arrays.asList( anAuction );

        instance.setAuctions(auctions);
        assertEquals(auctions, instance.getAuctions());
        tx.commit();

        tx.begin();
        instance = em.find(User.class, testObjectId);
        assertEquals(auctions, instance.getAuctions());
        tx.commit();
    }

    /**
     * Test of getBids method, of class User.
     */
    @Test
    public void testGetBids() {
        System.out.println("getBids");
        tx = em.getTransaction();
        tx.begin();
        User instance = em.find(User.class, testObjectId);
        List<Bid> result = instance.getBids();
        tx.commit();
        assertEquals(result.size(),0);
    }

    /**
     * Test of setBids method, of class User.
     */
    @Test
    public void testSetBids() {
        System.out.println("setBids");

        tx = em.getTransaction();
        tx.begin();
        User instance = em.find(User.class, testObjectId);

        Auction anAuction = new SimpleAuction(instance,EXPECTED_ITEM,5,1.0);
        List<Auction> auctions = Arrays.asList( anAuction );
        Bid aBid = anAuction.placeBid(instance, 5.0);
        List<Bid> bids = Arrays.asList(aBid);

        instance.setAuctions(auctions);
        instance.setBids(bids);
        tx.commit();
        assertEquals(auctions, instance.getAuctions());
        assertEquals(bids, instance.getBids());

        tx.begin();
        instance = em.find(User.class, testObjectId);
        assertEquals(bids, instance.getBids());
        tx.commit();
    }

    /**
     * Test of getUsername method, of class User.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        tx = em.getTransaction();
        tx.begin();
        User instance = em.find(User.class, testObjectId);
        String result = instance.getUsername();
        tx.commit();
        assertEquals(EXPECTED_NAME, result);
    }

    /**
     * Test of setUsername method, of class User.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        tx = em.getTransaction();
        tx.begin();
        User instance = em.find(User.class, testObjectId);
        instance.setUsername(NEW_NAME);
        assertEquals(NEW_NAME, instance.getUsername());
        tx.commit();

        tx.begin();
        instance = em.find(User.class, testObjectId);
        assertEquals(NEW_NAME, instance.getUsername());
        tx.commit();
    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        tx = em.getTransaction();
        tx.begin();
        User instance = em.find(User.class, testObjectId);
        String result = instance.getEmail();
        tx.commit();
        assertEquals(EXPECTED_EMAIL, result);
    }

    /**
     * Test of setEmail method, of class User.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        tx = em.getTransaction();
        tx.begin();
        User instance = em.find(User.class, testObjectId);
        instance.setEmail(NEW_EMAIL);
        assertEquals(NEW_EMAIL, instance.getEmail());
        tx.commit();

        tx.begin();
        instance = em.find(User.class, testObjectId);
        assertEquals(NEW_EMAIL, instance.getEmail());
        tx.commit();
    }

}
