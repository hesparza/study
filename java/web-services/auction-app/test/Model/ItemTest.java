/*
 */

package Model;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author education@oracle.com
 */
public class ItemTest extends GenericTest<Item> {

    private static final String EXPECTED_DESCRIPTION = "Initial Description";
    private static final String NEW_DESCRIPTION = "Updated Description";

    public ItemTest() {
        super( new Item( EXPECTED_DESCRIPTION ));
    }


    /**
     * Test of getDescription method, of class Item.
     */
    @Test
    public void testGetDescription() {
        log("getDescription");
        tx = em.getTransaction();
        tx.begin();
        Item instance = em.find(Item.class, testObjectId);
        String result = instance.getDescription();
        tx.commit();
        assertEquals(EXPECTED_DESCRIPTION, result);
    }

    /**
     * Test of setDescription method, of class Item.
     */
    @Test
    public void testSetDescription() {
        log("setDescription");
        tx = em.getTransaction();
        tx.begin();
        Item instance = em.find(Item.class, testObjectId);
        instance.setDescription(NEW_DESCRIPTION);
        assertEquals(NEW_DESCRIPTION, instance.getDescription());
        tx.commit();

        tx.begin();
        instance = em.find(Item.class, testObjectId);
        assertEquals(NEW_DESCRIPTION, instance.getDescription());
        tx.commit();
    }

    /**
     * Test of getImage method, of class Item.
     */
    @Test
    public void testGetImage() {
        log("getImage");
        tx = em.getTransaction();
        tx.begin();
        Item instance = em.find(Item.class, testObjectId);
        Image result = instance.getImage();
        tx.commit();
        assertNull(result);
    }

    /**
     * Test of setImage method, of class Item.
     */
    @Test
    public void testSetImage() throws IOException {
        log("setImage");

        InputStream is = 
            getClass().getResourceAsStream("/resources/duke.png");
        Image image = ImageIO.read(is);

        tx = em.getTransaction();
        tx.begin();
        Item instance = em.find(Item.class, testObjectId);
        instance.setImage(image);
        assertEquals(image, instance.getImage());
        tx.commit();

        tx.begin();
        instance = em.find(Item.class, testObjectId);
        Image result = instance.getImage();
        assertEquals(image.getHeight(null), result.getHeight(null));
        assertEquals(image.getWidth(null), result.getWidth(null));
        tx.commit();
    }

}
