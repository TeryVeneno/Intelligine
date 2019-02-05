package game;

import intelligine.render_engine.core.*;
import intelligine.render_engine.graphics.*;
import intelligine.utilities.Debug;
import java.awt.Color;
import intelligine.input_engine.Input;
import intelligine.input_engine.Mouse;

public class Game extends Scene {

  Image img;
  int y = 200, x = 100, cx = 0, cy = 0, sp_x = 0, sp_y = 0;;

  String coords = "0, 0";
  Sprite_Sheet sheet;

  public Game(int scene_id) {
    this.scene_id = scene_id;
  }

  public void render(Window win, Drawer d, Scene_Manager sm) {
    d.set_color(Color.WHITE);
    d.set_camera_pos(cx, cy);
    d.draw_string("Coords: " + coords, 100, 100);
    d.set_color(Color.RED);
    d.draw_image(sheet.get_sprite_image(sp_y, sp_x), x, y);
  }

  public void update(Window win, Scene_Manager sm) {
    Input inp = win.get_input();
    Mouse m = win.get_mouse();

    if (inp.is_key_down(inp.KEY_UP)) {
      cy -= 1;
    }
    if (inp.is_key_down(inp.KEY_DOWN)) {
      cy += 1;
    }
    if (inp.is_key_down(inp.KEY_LEFT)) {
      cx -= 1;
    }
    if (inp.is_key_down(inp.KEY_RIGHT)) {
      cx += 1;
    }
    if (inp.is_key_pressed(inp.KEY_1)) {
      sp_x = 0;
      sp_y = 0;
    }
    if (inp.is_key_pressed(inp.KEY_2)) {
      sp_x = 0;
      sp_y = 1;
    }
    if (inp.is_key_pressed(inp.KEY_3)) {
      sp_x = 1;
      sp_y = 0;
    }
    if (inp.is_key_pressed(inp.KEY_4)) {
      sp_x = 1;
      sp_y = 1;
    }

    coords = m.get_x() + ", " + m.get_y();
    x = m.get_x()-50;
    y = m.get_y()-50;
  }

  public void init(Window win, Scene_Manager sm) {
    img = new Image("Res/Face-1.png.png");
    sheet = new Sprite_Sheet(new Image("Res/StaffSpriteSheet.png"), 25, 25);
  }
}
