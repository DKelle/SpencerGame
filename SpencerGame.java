import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class SpencerGame extends JPanel{
//int
	int WIDTH = 1000;
	int HEIGHT = 500;

//String

//double

//boolean

//Rectangle

//arrayList


//JFrame
	JFrame j;

//Dimension
	Dimension dim;

	public static void main(String[]args){
		new SpencerGame();
	}

	public SpencerGame(){
		init();

		j = new JFrame();
		j.pack();
		j.setSize(WIDTH,HEIGHT);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setLocation((int)(dim.getWidth()/2 - WIDTH/2) ,(int)(dim.getHeight()/2 - HEIGHT/2));

		setFocusable(true);
		setFocusTraversalKeysEnabled(true);

		this.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e){}
			public void keyReleased(KeyEvent e){}
			public void keyTyped(KeyEvent e){}
		});

		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){}
			public void mouseReleased(MouseEvent e){}
			public void mouseClicked(MouseEvent e){}
		});

		this.addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseMoved(MouseEvent e ){
				System.out.println("mouse moved");
			}
			public void mouseDragged(MouseEvent e){
				System.out.println("mouse dragged");
			}
		});

		j.add(this);
		j.setResizable(false);
		j.setVisible(true);

	}

	public void init(){
		dim = Toolkit.getDefaultToolkit().getScreenSize();
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}



}