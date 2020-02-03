package intelligine.render_engine.core;

import intelligine.utilities.Debug;
import intelligine.input_engine.Input;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import java.awt.Canvas;
import intelligine.input_engine.Mouse;


public class Window extends Canvas {

  private static final long serialVersionUID = 42L;

  private JFrame frame;
  private Scene_Manager sm;
  private Drawer drawer;

  private static int width, height, buffer_size;
  private static String title;
  private static boolean is_running;
  private final double update_speed = 60;
  int frames, updates, time;


  private Thread loop;
  private Input input = new Input();
  private Mouse mouse = new Mouse();

  /** This class is used for creating the frame for Intelligine. Contains the main frame and updates the current Scene.*/
  public Window (String title, int width, int height, int buffer_size, Scene_Manager sm) {
    Window.title = title;
    Window.width = width;
    Window.buffer_size = buffer_size;
    this.sm = sm;

    Dimension size = new Dimension(width,height);
    frame = new JFrame(title);
    frame.setTitle(title);
    setPreferredSize(size);
    setSize(size);
    frame.setSize(size);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(this);
    frame.setResizable(false);
    setFocusable(true);
    frame.pack();
  }

  /** Displays the window. */
  public void display () {
    createBufferStrategy(buffer_size);
    frame.setVisible(true);
    is_running = true;
    drawer = new Drawer(this);
    start_input_listeners();
    loop();
  }

  /** Displays next buffer. */
  public void update () {
    if (!is_running) {
      Debug.log_error("Window not Initialized!");
    }
    getBufferStrategy().show();
  }

  /** Checks if the window is running. */
  public boolean is_running () {
    return is_running;
  }

  /** Clears the window. */
  public void clear (Color clear_color) {
    if (!is_running) {
      Debug.log_error("Window not Initialized!");
    }
    BufferStrategy st = getBufferStrategy();
    Graphics g = st.getDrawGraphics();
    g.setColor(clear_color);
    g.fillRect(0, 0, getWidth(), getHeight());
  }

  /** Closes the window. */
  public void close () {
    frame.dispose();
    System.exit(0);
  }

  public void set_fullscreen (boolean fullscreen) {
    if (fullscreen && !is_running) {
      frame.dispose();
      frame.setUndecorated(true);
      frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
      frame.setVisible(true);
    }
    width = getWidth(); height = getHeight();
  }

  /** The main loop. */
  private void loop () {
    loop = new Thread(() -> {
      double last_time = System.nanoTime();
      double delta = 0;
      final double ns = 1e9/update_speed;

      double start = System.currentTimeMillis();
      int next = 1;
      while(is_running) {
        double now_time = System.nanoTime();
        double now = (System.currentTimeMillis()-start)/1000;
        delta += (now_time-last_time)/ns;
        last_time = now_time;
        while(delta >= 1) {
          sm.render();
          update();
          delta--;
        }

        if (now >= next) {
          next++;
          time++;
          frames = 0;
          updates = 0;
        }
      }
    }); loop.start();
  }

  Drawer get_drawer () {
    return drawer;
  }

  private void start_input_listeners () {
    this.addKeyListener(input);
    this.addMouseListener(mouse);
    this.addMouseMotionListener(mouse);
  }

  public Input get_input () {
    return input;
  }

  public Mouse get_mouse () {
    return mouse;
  }
}
