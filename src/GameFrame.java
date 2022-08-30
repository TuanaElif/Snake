import javax.swing.JFrame;

public class GameFrame extends JFrame {
	
	//cosntructor for the gameframe class
	GameFrame(){
		
		this.add(new GamePanel());
		this.setTitle("Snake");
		//to close the program with the x button
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//to ensure that the graphical interface looks the way you intend to
		//to prevent the user from re-sizing it
		this.setResizable(false);
		//if we add components to JFrame the pack() function will take our
		//JFrame and fit it snugly around all of the components that we added to the frame
		this.pack();
		//blocks until dialog is closed
		this.setVisible(true);
		//sets the location of the window relative to the specified component
		this.setLocationRelativeTo(null);
	}
	
}
