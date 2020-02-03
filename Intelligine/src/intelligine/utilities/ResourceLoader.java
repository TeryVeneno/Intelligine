package intelligine.utilities;

import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class ResourceLoader {

  public static BufferedImage load_image (String path) {
      try {
        BufferedImage img = ImageIO.read(new File(path));
        return img;
      } catch(Exception e) {
        Debug.log_error(e.getMessage());
      }
    return null;
  }
}
