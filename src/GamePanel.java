import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener{

	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	//to specify how big we want our objects to be
	static final int UNIT_SIZE = 25;
	//how many objects we want to fit on it
	static final int GAME_UNITS = (SCREEN_WIDTH *SCREEN_HEIGHT)/UNIT_SIZE;
	//specify delay for the time
	//the higherthe number for the delay the slower the game will be
	static final int DELAY = 75;
	
	//creating two arrays
	//this array is going to hold all of the x coordinates of the body parts  
	final int x[] = new int [GAME_UNITS];
	//this one will hold all of the y coordinates
	final int y[] = new int [GAME_UNITS];
	
	//initial amount of bosy parts
	int bodyParts = 6;
	int applesEaten;
	int appleX; //the x positioning of the apple
	int appleY; //the y positioning of the apple
	char direction = 'R';//the start of the snake
	boolean running = false;
	Timer timer;
	Random random;
	
	//constructor for the gamepanel class
	GamePanel(){
		random = new Random ();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();
	}
	
	//method to start game
	public void startGame() {
		newApple();
		running = true;
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	//method to paint the component
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	//method to draw
	public void draw(Graphics g) {
		//turning the view to a grid
		for(int i=0;i<SCREEN_HEIGHT/UNIT_SIZE;i++) {
			g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
			g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
		}
		
	}
	
	public void newApple() {
		
	}
	
	//method to move
	public void move() {
		
	}
	
	//method to see if the snake eats the apple
	public void checkCollisions() {
		
	}
	
	//method to check whether the game is finished
	public void gameOver(Graphics g) {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//inner class
	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			
		}
	}

}
