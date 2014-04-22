package spaceInvaders;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.image.BufferedImage;
public class SpaceInvadersApp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel scorePanel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpaceInvadersApp frame = new SpaceInvadersApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public SpaceInvadersApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 828, 535);
		setTitle("Space Invaders");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Cursor invisibleCursor = createInvisibleCursor();
		contentPane.setCursor(invisibleCursor);
		
		GameBoard panel = createGameBoard();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel scorePanel = createScorePanel();
		scorePanel.setLayout(new GridLayout(10, 1, 0, 0));
		
		JLabel lblLives = createLivesLabel();
		scorePanel_1.add(lblLives);
		
	
		JLabel lblLivesCounter = createLivesCounter();
		scorePanel_1.add(lblLivesCounter);
	
		
		JLabel lblScore = createScoreLabel();
		scorePanel.add(lblScore);
		
		JLabel label = createScoreNumber();
		scorePanel.add(label);
	}


	private Cursor createInvisibleCursor() {
		BufferedImage cursor = new BufferedImage(16,16, BufferedImage.TYPE_INT_ARGB);
		Cursor invisibleCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursor, new Point(0,0), "invisible cursor");
		return invisibleCursor;
	}

	private JLabel createLivesCounter() {
		JLabel lblLivesCounter = new JLabel("5");
		lblLivesCounter.setForeground(Color.YELLOW);
		lblLivesCounter.setFont(new Font("OCR A Std", Font.PLAIN, 40));
		return lblLivesCounter;
	}

	private JLabel createLivesLabel() {
		JLabel lblLives = new JLabel("LIVES");
		lblLives.setForeground(Color.YELLOW);
		lblLives.setFont(new Font("OCR A Std", Font.PLAIN, 40));
		return lblLives;
	}

	private JLabel createScoreNumber() {
		JLabel label = new JLabel("0");
		label.setForeground(Color.YELLOW);
		label.setFont(new Font("OCR A Std", Font.PLAIN, 40));
		return label;
	}

	private JLabel createScoreLabel() {
		JLabel lblScore = new JLabel("SCORE");
		lblScore.setForeground(Color.YELLOW);
		lblScore.setFont(new Font("OCR A Std", Font.PLAIN, 40));
		return lblScore;
	}

	private JPanel createScorePanel() {
		scorePanel_1 = new JPanel();
		scorePanel_1.setBackground(Color.BLACK);
		contentPane.add(scorePanel_1, BorderLayout.EAST);
		return scorePanel_1;
	}

	private GameBoard createGameBoard() {
		GameBoard panel = new GameBoard();
		return panel;
	}

}

//Just seeing if this note was was pushed to the repository
