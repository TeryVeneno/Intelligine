package intelligine.render_engine.core;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;
import intelligine.render_engine.graphics.Image;


public class Drawer {

  private BufferStrategy st;
  private Graphics g;

  private int camera_x, camera_y;

  public Drawer (Window win) {
    this.st = win.getBufferStrategy();
    this.g = st.getDrawGraphics();
    set_color(Color.WHITE);
  }

  public void draw_string (String str, int x, int y) {
    g.drawString(str, x, y);
  }

  public void fillRect (int x, int y, int sx, int sy) {
    g.fillRect(x, y, sx, sy);
  }

  public void set_color (Color c) {
    g.setColor(c);
  }

  public void draw_image (Image img, int x, int y) {
    if (img != null) {
      g.drawImage(img.get_raw_image(), x, y, null);
    }
  }

  public void draw_image (BufferedImage img, int x, int y) {
    if (img != null) {
      g.drawImage(img, x, y, null);
    }
  }

  public void set_camera_pos (int cx, int cy) {
    g.translate(-camera_x, -camera_y);
    camera_x = cx; camera_y = cy;
    g.translate(camera_x, camera_y);
  }

  public void move_camera (int mx, int my) {
    camera_x += mx; camera_y += my;
    g.translate(mx, my);
  }
}
