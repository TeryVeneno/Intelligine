package intelligine.utilities;

public class Debug {
  /** This logs information to the console. */
  public static void log(String msg) {
    System.out.println(msg);
  }

  /** This logs errors to the console. */
  public static void log_error(String msg) {
    System.err.println(msg);
  }
}
