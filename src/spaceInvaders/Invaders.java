package spaceInvaders;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Invaders {
	
	private String invader = "invader.png";
	private int x; 
	private int y; 
	private int width;
	private int height; 
	private boolean visible; 
	private Image image; 
	
	public Invaders(int x, int y){
		ImageIcon inv = new ImageIcon(this.getClass().getResource(invader));
	    image = inv.getImage();
	    width = image.getWidth(null);
	    height = image.getHeight(null); 
	    visible = true; 
	    this.x = 200;
	    this.y = 100;
	}
	
	public void move(){
		if(x < 0)
			x = 600;
		x -= 1; 
	}


	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void setVisible(Boolean visible) {
        this.visible = visible;
    }
 
	public boolean isVisible() {

		return visible;
	}

	public Image getImage() {
		return image;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, width, height); 
	}


	
}
