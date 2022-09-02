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
	static final int GAME_UNITS = (SCREEN_WIDTH *SCREEN_HEIGHT)/(UNIT_SIZE);
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
		g.setColor(Color.red);
		g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
		
		//draw the head of the snake and the body
		for (int i=0; i<bodyParts; i++) {
			//we are dealing with the head of the snake
			if (i == 0) {
				g.setColor(Color.green);
				g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
			}
			//dealing with the body of the snake
			else {
				g.setColor(new Color(45, 180, 0));
				g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
			}
			
		}
	}
	
	public void newApple() {
		
		//generating the coordinates
		appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
		appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
		
	}
	
	//method to move
	public void move() {
		for (int i= bodyParts; i>0; i--) {
			x[i] = x[i-1]; //shifting all the coordinates in this array over by one spot 
			y[i] = y[i-1];
		}
		
		//creating a case in each possible directions (R, L, U, D)
		switch (direction) {
		case 'U':
			y[0] = y[0] - UNIT_SIZE;
			break;
		case 'D':
			y[0] = y[0] + UNIT_SIZE;
			break;
		case 'L':
			x[0] = x[0] - UNIT_SIZE;
			break;
		case 'R':
			x[0] = x[0] + UNIT_SIZE;
			break;
		}
		
	}
	
	//method to see if the snake eats the apple
	public void checkCollisions() {
		//checks if head of the snake collides with the body
		//iterate through all of the body parts of the snake
		for (int i= bodyParts; i>0; i--) {
			if((x[0] == x[i]) && (y[0] == y[i])) {
				//to trigger a game over method
				running = false;
			}
		}
		
		//check if head touches left border
		if(x[0] < 0) {
			running = false;
		}
		
		//checks if the head touches the right border
		if(x[0] > SCREEN_WIDTH) {
			running = false;
		}
		
		//checks if head touches top border
		if(y[0] > 0) {
			running = false;
		}
		
		//checks if head touches bottom corner
		if (y[0] >SCREEN_HEIGHT) {
			running = false;
		}
		
		if(!running) {
			timer.stop();
		}
		
		
	}
	
	//method to check whether the game is finished
	public void gameOver(Graphics g) {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		//to move our snake
		if(running) {
			move();
			checkApple();
			checkCollisions();
		}
		repaint();
		
	}
	
	private void checkApple() {
		// TODO Auto-generated method stub
		
	}

	//inner class
	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			//creating a switch that is going to examine the e key event
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
			//check to see if the direction goes to left
				if(direction != 'R') {
					//if true then the direction is on the left
					direction = 'L';
				}
				break;
			case KeyEvent.VK_RIGHT:
				//vice versa
				if (direction != 'L') {
					direction = 'R';
				}
				break;
			case KeyEvent.VK_UP:
				//vice versa
				if (direction != 'D') {
					direction = 'U';
				}
				break;
			case KeyEvent.VK_DOWN:
				//vice versa
				if (direction != 'U') {
					direction = 'D';
				}
				break;
			}
		}
		
		//learn these codes by hard
	}

}
