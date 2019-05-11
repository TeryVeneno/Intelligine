package intelligine.physics_engine.objects;

import intelligine.render_engine.core.*;
import intelligine.render_engine.graphics.Image;
import intelligine.utilities.Debug;
import java.awt.Color;

public abstract class Game_Object {

  protected int x, y, sx, sy;
  protected boolean do_draw, did_draw, has_image, has_physics_body, is_destroyed;
  protected Image img;
  protected Physics_Body body;

  public void render (Window win, Drawer d) {
    did_draw = false;
    if (do_draw) {
      Debug.log("Rendering");
      if (has_image) {
        Debug.log("Image rendering");
        d.draw_image(img, x, y);
      } else {
        Debug.log("Box Rendering");
        d.set_color(Color.GREEN);
        d.fill_rect(x, y, sx, sy);
        Debug.log("Rendered");
      }
      did_draw = true;
    }
  }

  abstract public void update (Window win);

  public int get_x () {return x;}
  public int get_y () {return y;}
  public int get_sx () {return sx;}
  public int get_sy () {return sy;}

  public boolean get_did_draw () {return did_draw;}

  public void set_image (Image img) {img = new Image(img.get_raw_image());}
  public void set_physics (Physics_Body pb) {body = pb;}


}
