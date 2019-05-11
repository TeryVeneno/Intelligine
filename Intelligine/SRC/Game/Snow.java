package game;

import intelligine.render_engine.core.*;
import intelligine.render_engine.graphics.*;
import intelligine.utilities.Debug;
import java.awt.Color;
import net.coobird.thumbnailator.*;
import intelligine.input_engine.Input;
import intelligine.input_engine.Mouse;
import java.util.*;

public class Snow extends Scene {

  Image img;
  Image[] images = new Image[600];
  int[] xs = new int[600];
  int[] ys = new int[600];
  int y = 200, x = 100, cx = 0, cy = 0, sp_x = 0, sp_y = 0;;

  String coords = "0, 0";
  Sprite_Sheet sheet;
  Random rand = new Random(System.currentTimeMillis());

  public Game(int scene_id) {
    this.scene_id = scene_id;
  }

  public void render(Window win, Drawer d, Scene_Manager sm) {
    for (int s = 0; s < 600; s++) {
      d.draw_image(images[s], xs[s], ys[s]);
    }
  }

  public void update(Window win, Scene_Manager sm) {
    Input input = win.get_input();
    for (int s = 0; s < 600; s++) {
      ys[s] = ys[s]+rand.nextInt(3);
      if (ys[s] >= 800) {
        ys[s] = 0;
      }
    }
    if (input.is_key_pressed(Input.KEY_Q)) {
      win.close();
    }
  }

  public void init(Window win, Scene_Manager sm) {
    img = new Image("Res/Snow Flake.png");
    for (int s = 0; s < 600; s++) {
      try {
        images[s] = new Image(Thumbnails.of(img.get_raw_image()).size(rand.nextInt(35)+1, rand.nextInt(35)+1).asBufferedImage());
      } catch(Exception e) {
        e.printStackTrace();
      }
      xs[s] = rand.nextInt(win.getWidth());
      ys[s] = rand.nextInt(win.getHeight());
    }
  }
}
