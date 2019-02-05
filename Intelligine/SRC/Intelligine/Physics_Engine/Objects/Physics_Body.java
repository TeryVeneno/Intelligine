package intelligine.physics_engine.objects;

import intelligine.physics_engine.collision.Vector2D;

public class Physics_Body {

  private double mass;
  private Vector2D velocity_x;
  private Vector2D velocity_y;

  public Physics_Body (double mass, Vector2D vx, Vector2D vy) {
    this.mass = mass;
    velocity_x = new Vector2D(vx);
    velocity_y = new Vector2D(vy);
  }

  public Physics_Body (double mass) {
    this.mass = mass;
    velocity_x = new Vector2D(0, 0);
    velocity_y = new Vector2D(0, 90);
  }

  public Physics_Body () {
    mass = 100;
    velocity_x = new Vector2D(0, 0);
    velocity_y = new Vector2D(0, 90);
  }

  public int translate_x (int x) {
    if (velocity_x.get_mag() < 0 && velocity_x.get_dir() == 0.0) {
      velocity_x.set_dir(180.0);
      velocity_x.set_mag(-velocity_x.get_mag());
    }
    if (velocity_x.get_mag() < 0 && velocity_x.get_dir() == 180.0) {
      velocity_x.set_dir(0.0);
      velocity_x.set_mag(-velocity_x.get_mag());
    }
    return Vector2D.x_update(velocity_x, x);
  }

  public int translate_y (int y) {
    if (velocity_y.get_mag() < 0 && velocity_y.get_dir() == 270.0) {
      velocity_y.set_dir(90.0);
      velocity_y.set_mag(-velocity_y.get_mag());
    }
    return Vector2D.y_update(velocity_y, y);
  }

  public void apply_gravity (Vector2D gravity) {
    if (velocity_y.get_mag() < 0 && velocity_y.get_dir() == 90.0) {
      velocity_y.set_dir(270.0);
      velocity_y.set_mag(-velocity_y.get_mag());
    }
    if (velocity_y.get_dir() == 90.0) {
      velocity_y.update_mag(-gravity.get_mag());
    } else {
      velocity_y.update_mag(gravity.get_mag());
    }
  }

  public void apply_forcex (Vector2D vx) {
    if (velocity_x.get_dir()-vx.get_dir() != 0) {
      velocity_x.set_mag(velocity_x.get_mag()-vx.get_mag()/mass);
    } else {
      velocity_x.set_mag(velocity_x.get_mag()+vx.get_mag()/mass);
    }
  }

  public void apply_forcey (Vector2D vy) {
    if (velocity_y.get_dir()-vy.get_dir() != 0) {
      velocity_y.set_mag(velocity_y.get_mag()-vy.get_mag()/mass);
    } else {
      velocity_y.set_mag(velocity_y.get_mag()+vy.get_mag()/mass);
    }
  }

  public void apply_friction (double friction_constant, double gravity_acceleration) {
    apply_forcex(new Vector2D(friction_constant*mass*gravity_acceleration, 180-velocity_x.get_dir()));
  }

  public double get_mass () {
    return mass;
  }

  public Vector2D get_velocity_x () {
    return velocity_x;
  }

  public Vector2D get_velocity_y () {
    return velocity_y;
  }
}
