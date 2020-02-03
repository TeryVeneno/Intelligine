package game;

import intelligine.physics_engine.objects.Game_Object;
import intelligine.render_engine.core.*;


public class Block extends Game_Object {

  public Block (int x, int y, int size) {
    this.x = x;
    this.y = y;
    sx = size;
    sy = size;
    do_draw = true;
  }

  public void update (Window win, Scene_Manager sm) {}

}
