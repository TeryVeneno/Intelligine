package intelligine.physics_engine.collision;

public class Point2D {
  private int x, y;

  public Point2D (int x, int y) {this.x = x; this.y = y;}

  public Point2D (Point2D p) {this.x = p.get_x(); this.y = p.get_y();}

  public int get_x () {return x;}
  public int get_y (){return y;}

  public void set_x (int x) {this.x = x;}
  public void set_y (int y) {this.y = y;}
  public void set_xy (int x, int y) {this.x = x; this.y = y;}
  public void set_xy (Point2D p) {this.x = p.get_x(); this.y = p.get_y();}

  public void translate (int val) {x += val; y += val;}
  public void translate (int x_val, int y_val) {x += x_val; y += y_val;}
  public static Point2D translate (Point2D p, int val)  {return new Point2D(p.get_x()+val, p.get_y()+val);}
  public static Point2D translate (Point2D p, int x_val, int y_val) {
    return new Point2D(p.get_x()+x_val, p.get_y()+y_val);
  }
}
