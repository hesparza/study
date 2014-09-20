package Model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author education@oracle.com
 */
@Entity @XmlRootElement
public class Item extends DomainEntity {

  /**
   *
   */
  public Item() {
  }

  public Item( String description ) {
    this.description = description;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription( String description ) {
    this.description = description;
  }

  /**
   * @return the image
   */
  public Image getImage() {
    if (image != null) {
      return image;
    } else if (imageData == null) {
      return null;
    } else {
      ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
      try {
        return image = ImageIO.read( bis );
      } catch (IOException ex) {
        return null;
      }
    }
  }

  /**
   * @param image the image to set
   */
  public void setImage( Image image ) {
    if (image == null) {
      this.image = null;
      imageData = null;
    } else {
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      try {
        ImageIO.write( (BufferedImage) image, "png", bos );
        imageData = bos.toByteArray();
        this.image = image;
      } catch( IOException ex ) {
        // keep original image, if any...
      }
    }
  }
  /**
   *
   */
  private String description;

  @Lob @Basic(fetch=FetchType.LAZY)
  private byte[] imageData;
  transient Image image;    // to convert byte[] to Image lazily
}
