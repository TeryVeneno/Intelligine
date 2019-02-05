package intelligine.render_engine.core;

import java.util.ArrayList;
import java.awt.Color;


public class Scene_Manager {

  private ArrayList<Scene> scenes = new ArrayList<Scene>();
  private Scene current_scene;
  private Window win;

  // Scene Acess
  public void addScene (Scene scene) {
    scenes.add(scene);
  }

  public void flushScenes () {
    scenes.clear();
  }

  public void enter_scene (int scene_id, boolean do_init) {
    current_scene = scenes.get(scene_id);
    if (do_init) {
      current_scene.init(win, this);
    }
  }

  public Window create_window (String title, int width, int height, int buffer_size, Scene_Manager sm) {
    win = new Window(title, width, height, buffer_size, sm);
    return win;
  }

  // Window access

  void init () {
    if (is_scene_open())
      current_scene.init(win, this);
  }

  void render () {
    if (is_scene_open()) {
      win.clear(Color.BLACK);
      update();
      current_scene.render(win, win.get_drawer(), this);
      win.frames++;
    }
  }

  void update () {
    if (is_scene_open()) {
      current_scene.update(win, this);
      win.updates++;
    }
  }

  private boolean is_scene_open () {
    return ((current_scene == null) ? false : true);
  }
}
