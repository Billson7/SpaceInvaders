package spaceInvaders;

import java.awt.Image;

import javax.swing.ImageIcon;

public class PlayerBullet {

	private int x, y;
    private Image image;
    boolean visible;
    private int width, height; 
 
    private final int BOARD_HEIGHT = 420;
    private final int MISSILE_SPEED = 2;

    public PlayerBullet(int x, int y) {

        ImageIcon bullets = new ImageIcon(this.getClass().getResource("playerbullet.png"));
        image = bullets.getImage();
        visible = true;
        this.x = x;
        this.y = y;
    }


    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void move() {
        y -= MISSILE_SPEED;
        if (y > BOARD_HEIGHT)
            visible = false;
    }
}
