package intelligine.render_engine.graphics;

import java.awt.image.BufferedImage;
import intelligine.utilities.Debug;

public class Sprite_Sheet {

  private BufferedImage img;
  private int sx, sy;

  public Sprite_Sheet (Image img, int sx, int sy) {
    this.img = img.get_raw_image();
    this.sx = sx;
    this.sy = sy;
  }

  public BufferedImage get_sprite_image (int y, int x) {
    try {
      return img.getSubimage(x*sx, y*sy, sx, sy);
    } catch(Exception e) {
      Debug.log_error("SpriteSheet <Failed to Acquire SubImage>");
    }
    return null;
  }

  public Image get_sprite (int array_x, int array_y) {
    return new Image(get_sprite_image(array_y, array_x));
  }
}
