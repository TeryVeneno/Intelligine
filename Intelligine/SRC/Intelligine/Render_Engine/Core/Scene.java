package intelligine.render_engine.core;



public abstract class Scene {
  protected int scene_id;

  public abstract void render(Window win, Drawer d, Scene_Manager sm);

  public abstract void update(Window win, Scene_Manager sm);

  public abstract void init(Window win, Scene_Manager sm);

  public int get_scene () {
    return scene_id;
  }
}
