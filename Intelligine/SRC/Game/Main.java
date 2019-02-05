package game;

import intelligine.render_engine.core.*;
import java.awt.Color;


public class Main extends Scene_Manager {
  private static final long serialVersionUID = 42l;

  //private static int width=700, height=500, buffer_size=2;
  //private static String title = "Game Engine Test";
  private static Window win;

  private static final int scene_id = 0;;

  public Main (String title, int width, int height, int buffer_size) {
    win = this.create_window(title, width, height, buffer_size, this);
    win.display();
  }

  public static void main(String[] args) {
    Main m = new Main("Game Engine Test", 700, 500, 2);
    m.addScene(new Game(0));
    m.enter_scene(0, true);
  }
}
