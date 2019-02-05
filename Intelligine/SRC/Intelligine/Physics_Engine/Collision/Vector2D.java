package intelligine.physics_engine.collision;

public class Vector2D {

  /** The magnitude of the vector.*/
  private double magnitude;
  /** The direction of the vector.*/
  private double direction;

  /**
  * A class to represent vectors in 2D space.
  * @param mag the value magnitude should start as.
  * @param dir the value direction should start as.
  */
  public Vector2D (double mag, double dir) {
    magnitude = mag;
    direction = dir;
  }

  /**
  * A class to represent vectors in 2D space.
  * @param v A vector that this vector should copy.
  */
  public Vector2D (Vector2D v) {
    magnitude = v.get_mag();
    direction = v.get_dir();
  }

  /**
  * A method to access the magnitude.
  * @return the magnitude of the vector
  */
  public double get_mag () {
    return magnitude;
  }

  /**
  * A method to access the direction.
  * @return the direction of the vector
  */
  public double get_dir () {
    return direction;
  }

  /**
  * A method to set the magnitude.
  * @param mag The value to set the magnitude to.
  */
  public void set_mag (double mag) {
    magnitude = mag;
  }

  /**
  * A method to set the direction.
  * @param dir The value to set the direction to.
  */
  public void set_dir (double dir) {
    direction = dir;
  }

  /**
  * A method to update the magnitude.
  * @param val The value to update the magnitude with.
  */
  public void update_mag (double val) {
    magnitude += val;
  }

  /**
  * A method to update the direction.
  * @param val The value to update the direction with.
  */
  public void update_dir (double val) {
    direction += val;
  }

  /**
  * A method to add a vector to this vector.
  * @param v The vector to add to the current vector.
  */
  public void add (Vector2D v) {
    magnitude += v.get_mag();
    direction += v.get_dir();
  }

  /**
  * A method to subtract a vector from this vector.
  * @param v The vector to subtract from the current vector.
  */
  public void subtract (Vector2D v) {
    magnitude -= v.get_mag();
    direction -= v.get_dir();
  }

  /**
  * A method to multiply a vector with this vector.
  * @param v The vector to multiply with the current vector.
  */
  public void multiply (Vector2D v) {
    magnitude *= v.get_mag();
    direction *= v.get_dir();
  }

  /**
  * A method to divide a vector from this vector.
  * @param v The vector to divide from the current vector.
  */
  public void divide (Vector2D v) {
    magnitude /= v.get_mag();
    direction /= v.get_dir();
  }

  public void combine (Vector2D v) {
    magnitude = (magnitude + v.get_mag())/2;
    direction = (direction + v.get_dir())/2;
  }

  /**
  * A method to find angular movement for this vector and update the x.
  * @param v The vector which contains the magnitude and direction to use.
  * @param x The baseline x value to update.
  * @return The updated x value.
  */
  public static int x_update (Vector2D v, double x) {
    int x_change = (int)x;
    x_change += (int)(Math.cos((Math.toRadians(v.get_dir())))*v.get_mag());
    return x_change;
  }

  /**
  * A method to find angular movement for this vector and update the y.
  * @param v The vector which contains the magnitude and direction to use.
  * @param y The baseline y value to update.
  * @return The updated y value.
  */
  public static int y_update (Vector2D v, double y) {
    int y_change = (int)y;
    y_change += (int)(Math.sin((Math.toRadians(v.get_dir())))*v.get_mag());
    return y_change;
  }

  /**
  * A method to find angular movement for this vector.
  * @param v The vector which contains the magnitude and direction to use.
  * @return The angular movmenet in the x for this vector.
  */
  public static int x_change (Vector2D v) {
    return (int)(Math.cos((Math.toRadians(v.get_dir())))*v.get_mag());
  }

  /**
  * A method to find angular movement for this vector.
  * @param v The vector which contains the magnitude and direction to use.
  * @return The angular movmenet in the y for this vector.
  */
  public static int y_change (Vector2D v) {
    return (int)(Math.sin((Math.toRadians(v.get_dir())))*v.get_mag());
  }

  public static Vector2D add (Vector2D v, Vector2D v2) {
    Vector2D ret = new Vector2D(v); ret.add(v2); return ret;
  }

  public static Vector2D subtract (Vector2D v, Vector2D v2) {
    Vector2D ret = new Vector2D(v); ret.subtract(v2); return ret;
  }

  public static Vector2D multiply (Vector2D v, Vector2D v2) {
    Vector2D ret = new Vector2D(v); ret.multiply(v2); return ret;
  }

  public static Vector2D divide (Vector2D v, Vector2D v2) {
    Vector2D ret = new Vector2D(v); ret.divide(v2); return ret;
  }

  public static Vector2D combine (Vector2D v, Vector2D v2) {
    Vector2D ret = new Vector2D(v); ret.combine(v2); return ret;
  }

  public String toString () {
    return "["+magnitude+", "+direction+"]";
  }
}
