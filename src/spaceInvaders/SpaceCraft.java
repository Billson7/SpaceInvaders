package spaceInvaders;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class SpaceCraft {
	
	private String spaceCraft = "spaceshipmain.png";
	private int move_x;
	private int x;
	private int y;
	private Image player; 
	private int key; 
	private ArrayList<PlayerBullet> bullets = new ArrayList<>(); 
	private final int SPACESHIP_LEFT = 15; 
	private final int SPACESHIP_RIGHT = 35;

	public SpaceCraft() {
		ImageIcon sp = new ImageIcon(this.getClass().getResource(spaceCraft));
	    player = sp.getImage();
	    x = 310;
	    y = 412;
	}

	public void move() {
	    x += move_x;
	    
	    if (x < 1){
	    	x=1; 
	    }
	    if (x > 600){
	    	x = 600;
	    }
	    
	}

	public int getX() {
	    return x;
	}

	public int getY() {
	    return y;
	}
	    
	public Image getImage() {
	    return player;
	}
	
	public ArrayList getBullets(){
		return bullets; 
	}
	
	public void shoot(){
		bullets.add(new PlayerBullet(x + SPACESHIP_LEFT, y + SPACESHIP_LEFT/2));
		bullets.add(new PlayerBullet(x + SPACESHIP_RIGHT, y + SPACESHIP_RIGHT/4));
	}
	
	public void keyPressed(KeyEvent e) {

	    key = e.getKeyCode();
	    
	    if (key == KeyEvent.VK_UP){
	    	shoot();
	    }
	    
	    if (key == KeyEvent.VK_W){
	    	shoot();
	    }

	    if (key == KeyEvent.VK_A) {
	    	move_x= -1;
	    }
	    if (key == KeyEvent.VK_LEFT) {
	    	move_x= -1;
	    }

	    if (key == KeyEvent.VK_D) {
	    	move_x = 1;
	    }
	    if (key == KeyEvent.VK_RIGHT) {
	    	move_x= 1;
	    }
	}
	   
	public void keyReleased(KeyEvent e) {
	    key = e.getKeyCode();

	    if (key == KeyEvent.VK_A) {
	    	move_x = 0;
	    }
	    if (key == KeyEvent.VK_LEFT) {
	    	move_x= 0;
	    }

	    if (key == KeyEvent.VK_D) {
	    	move_x = 0;
	    }
	    if (key == KeyEvent.VK_RIGHT) {
	    	move_x= 0;
	    }
	}
}
