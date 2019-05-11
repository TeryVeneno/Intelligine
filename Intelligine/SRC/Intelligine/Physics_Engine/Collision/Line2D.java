package intelligine.physics_engine.collision;

public class Line2D {

  private Point2D p1, p2;

  public Line2D (Point2D p1, Point2D p2) {this.p1 = new Point2D(p1); this.p2 = new Point2D(p2);}
  public Line2D (int x1, int x2, int y1, int y2) {this(new Point2D(x1, y1), new Point2D(x2, y2));}
  public Line2D (Line2D l) {this(l.get_p1(), l.get_p2());}

  public Point2D get_p1 () {return p1;}
  public Point2D get_p2 () {return p2;}

  public Vector2D convert_to_vector () {
    double mag = Math.sqrt(Math.pow(p1.get_x()-p2.get_x(),2)+Math.pow(p1.get_y()-p2 .get_y(),2));
    double yc = Math.abs(p1.get_y()-p2.get_y())/mag; double xc = Math.abs(p1.get_x()-p2.get_x())/mag;
    if (yc < 0 && xc < 0) {
      return new Vector2D (mag, (Math.toDegrees(Math.acos(xc))+Math.toDegrees(Math.asin(yc)))/2);
    } else if (xc < 0 && yc > 0) {
      return new Vector2D(mag, Math.toDegrees(Math.acos(xc)));
    } else if (yc < 0 && xc > 0) {
      return new Vector2D(mag,  Math.toDegrees(Math.asin(yc)));
    } else if (yc == 0.0 && xc < 0) {
      return new Vector2D(mag, Math.toDegrees(Math.acos(xc)));
    } else if (xc == 0.0 && yc < 0) {
      return new Vector2D(mag, Math.toDegrees(Math.asin(yc)));
    }
    return new Vector2D(0,0);
  }

  public boolean intersecting (Line2D l) {
    Line2D l1 = new Line2D (Point2D.translate(p1, -p1.get_x(), -p1.get_y()),
                            Point2D.translate(p2, -p1.get_x(), -p1.get_y()));
    Line2D l2 = new Line2D (Point2D.translate(l.get_p1(), -p1.get_x(), -p1.get_y()),
                            Point2D.translate(l.get_p2(), -p1.get_x(), -p1.get_y()));
    Line2D l3 = new Line2D (Point2D.translate(p1, -l.get_p1().get_x(), -l.get_p1().get_y()),
                            Point2D.translate(p2, -l.get_p1().get_x(), -l.get_p1().get_y()));
    Line2D l4 = new Line2D (Point2D.translate(l.get_p1(), -l.get_p1().get_x(), -l.get_p1().get_y()),
                            Point2D.translate(l.get_p2(), -l.get_p1().get_x(), -l.get_p1().get_y()));
    double c1 = (l1.get_p2().get_x()*l2.get_p1().get_y())-(l1.get_p2().get_y()*l2.get_p1().get_x());
    double c2 = (l1.get_p2().get_x()*l2.get_p2().get_y())-(l1.get_p2().get_y()*l2.get_p2().get_x());
    double c3 = (l2.get_p2().get_x()*l1.get_p1().get_y())-(l2.get_p2().get_y()*l1.get_p1().get_x());
    double c4 = (l2.get_p2().get_x()*l1.get_p2().get_y())-(l2.get_p2().get_y()*l1.get_p2().get_x());

    if (c1 < 0 && c2 < 0) {
      return false;
    }
    if (c1 > 0 && c2 > 0) {
      return false;
    }
    if (c3 < 0 && c4 < 0) {
      return false;
    }
    if (c3 > 0 && c4 > 0) {
      return false;
    }
    return true;
  }
}
