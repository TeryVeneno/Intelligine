package intelligine.physics_engine.collision;

public class Collider2D {

  private Line2D[] lines;
  private int x, y;

  public Collider2D (Line2D[] l, int x, int y) {
    lines = l; this.x = x; this.y = y;
  }

  public int get_x () {return x;}
  public int get_y () {return y;}

  public Line2D[] get_lines () {return lines;}
  public Line2D get_line (int index) {return lines[index];}

  public int get_length () {return lines.length;}

  public boolean intersecting (Collider2D cl) {
    for (Line2D line : lines) {
      for (int i = 0; i < cl.get_length(); i++) {
        if (line.intersecting(cl.get_line(i))) {
          return true;
        }
      }
    }
    return false;
  }
}
