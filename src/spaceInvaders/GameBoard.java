package spaceInvaders;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.ImageIcon;
/**
 * 
 * @author Rachael
 *
 */
public class GameBoard extends JLabel implements ActionListener{
	  /**
	 * Class GameBoard that implements ActionListener so that the 
	 * KeyAdapter will listen to specified keyboard input from the keyboard.
	 * It is also a JLabel so that we can set an icon for the background image. 
	 */
	private static final long serialVersionUID = 1L;
	private Timer timer;
	private SpaceCraft craft;
	private ArrayList<Invaders> invaders = new ArrayList<>(); 
	private boolean ingame;
	private int B_WIDTH;
	private int B_HEIGHT;
	
	 //Positions of where the aliens first appear initially
	private int[][] pos = { 
        {400, 29}, {400, 59}, {1380, 89},
        {780, 109}, {580, 139}, {680, 239}, 
        {790, 259}, {760, 50}, {790, 150},
        {980, 209}, {560, 45}, {510, 70},
        {930, 159}, {590, 80}, {530, 60},
        {940, 59}, {990, 30}, {920, 200},
        {900, 259}, {660, 50}, {540, 90},
        {810, 220}, {860, 20}, {740, 180},
        {820, 128}, {490, 170}, {700, 30}
     };
	/**
	 * Method GameBoard that sets up the how the JLabel (Playable) area will look. 
	 * The icon set up is the background "stars.jpg," it adds a keyListener and
	 * initializes a Swing Timer that is set to 5 milliseconds so that the objects 
	 * including the aliens and the player can move fluidly across the screen. 
	 */
	public GameBoard() {
    	setIcon(new ImageIcon(GameBoard.class.getResource("/spaceInvaders/stars.jpg")));

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        
       // setSize(400, 300); 
        craft = new SpaceCraft(); 
        initInvaders();
        timer = new Timer(5, this);
        timer.start();
	 }


	public void addNotify(){
		super.addNotify();
		B_WIDTH = getWidth();
		B_HEIGHT = getHeight(); 
		
	}
	
	public void initInvaders(){
		for(int i = 0; i < pos.length; i++){
			invaders.add(new Invaders(pos[i][0], pos[i][1]));
		}
	}
	
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);
       
        ArrayList b = craft.getBullets();

        for (int i = 0; i < b.size(); i++ ) {
            PlayerBullet m = (PlayerBullet) b.get(i);
            g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
        }
        
        for (int i = 0; i < invaders.size(); i++){
        	Invaders inv = (Invaders)invaders.get(i);
        	if (inv.isVisible()){
        		g2d.drawImage(inv.getImage(), inv.getX(), inv.getY(), this);
        	}
        
        }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e) {
    	ArrayList b = craft.getBullets();

        for (int i = 0; i < b.size(); i++) {
        	PlayerBullet m = (PlayerBullet) b.get(i);
        	if (m.isVisible()) 
        		m.move();
            else b.remove(i);
        }
        
        for (int i = 0; i < invaders.size(); i++){
        	Invaders inv = (Invaders) invaders.get(i);
        	if (inv.isVisible())
        		inv.move();
        	else invaders.remove(i); 
        	
        }
        craft.move();
        repaint();  
    }
	
    public void checkCollisions(){
    	
   
    }
    
    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            craft.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            craft.keyPressed(e);
        }
    }

}
