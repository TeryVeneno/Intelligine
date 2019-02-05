package intelligine.render_engine.graphics;

import java.awt.image.BufferedImage;
import intelligine.utilities.Debug;
import intelligine.utilities.ResourceLoader;

public class Image {

  private BufferedImage img;

  public Image (String path) {
    img = ResourceLoader.load_image(path);
  }

  public Image (BufferedImage img) {
    this.img = img;
  }

  public BufferedImage get_raw_image () {
    return img;
  }

  public int getWidth () {
    Debug.log("width");
    return img.getWidth();
  }

  public int getHeight() {
    return img.getHeight();
  }

  public void scale_image (int new_width, int new_height) {
    img = img.getScaledInstance(new_width, new_height, java.awt.Image.SCALE_DEFAULT);
  }
}
