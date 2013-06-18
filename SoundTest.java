import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SoundTest extends JPanel{

	Sound walk = new Sound("SoundFX/walk.wav");
	private int x = 0;
	private int y = 0;
	private boolean right = false;


	public static void main(String[]args){

		Sound die = new Sound("SoundFX/die.wav");




		new SoundTest();



	}

	public SoundTest(){

		JFrame j = new JFrame();
		j.setSize(500,500);
		j.add(this);


		setFocusable(true);
//		setFocusTraversalKeys(true);

		this.addKeyListener(new KeyListener(){

			public void keyPressed(KeyEvent e){
				System.out.println("asdf");
				if(e.getKeyCode() == KeyEvent.VK_D){
					right = true;
				}
			}
			public void keyReleased(KeyEvent e){
				if(e.getKeyCode() == KeyEvent.VK_D){
					right = false;
				}
			}
			public void keyTyped(KeyEvent e){}
		});
		Timer t = new Timer(50, new ActionListener(){
			public void actionPerformed(ActionEvent e){
				update();
				repaint();
			}
		});
		t.start();

		j.setDefaultCloseOperation(3);
		j.setVisible(true);

	}

	public void update(){
		if(right){
			x+=15;
			walk.play();
		}
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.fillRect(x,y,15,15);
	}
}