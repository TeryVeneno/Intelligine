package game;

import intelligine.render_engine.core.*;
import intelligine.render_engine.graphics.*;
import intelligine.utilities.Debug;
import java.awt.Color;
import intelligine.input_engine.Input;
import intelligine.input_engine.Mouse;
import java.util.*;

public class Game extends Scene {

  Block b;

  public Game(int scene_id) {
    this.scene_id = scene_id;
  }

  public void render (Window win, Drawer d, Scene_Manager sm) {
    d.fill_rect(100, 100, 10, 10);
    b.render(win, d);
  }

  public void update (Window win, Scene_Manager sm) {

  }

  public void init (Window win, Scene_Manager sm) {
    b = new Block(100, 100, 50);
  }
}
