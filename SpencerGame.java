import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class SpencerGame extends JPanel{
//int
	int WIDTH = 1000;
	int HEIGHT = 650;



//String

//double

//boolean


//Rectangle

//arrayList
	ArrayList<Person> peopleList = new ArrayList<Person>();

//JFrame
	JFrame j;

//Dimension
	Dimension dim;

//sound


//Player
	Player player;

//Point
	private Point mouseP;



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
			public void keyPressed(KeyEvent e){

				if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT){
					player.dirs[player.right] = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT){
					player.dirs[player.left] = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP){
					player.dirs[player.up] = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN){
					player.dirs[player.down] = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_SPACE ){
					player.shooting = true;

				}
			}
			public void keyReleased(KeyEvent e){

				if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT){
					player.dirs[player.right] = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT){
					player.dirs[player.left] = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP){
					player.dirs[player.up] = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN){
					player.dirs[player.down] = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_SPACE ){
					player.shooting = false;
				}

			}
			public void keyTyped(KeyEvent e){}
		});

		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){}
			public void mouseReleased(MouseEvent e){}
			public void mouseClicked(MouseEvent e){}
		});

		this.addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseMoved(MouseEvent e ){
				//System.out.println("mouse moved");
				mouseP = e.getPoint();
			}
			public void mouseDragged(MouseEvent e){
				//System.out.println("mouse dragged");
			}
		});

		this.setBackground(Color.black);

		j.add(this);
		j.setResizable(false);
		j.setVisible(true);


		Timer t = new Timer(50, new ActionListener(){
			public void actionPerformed(ActionEvent e){
				update();
				repaint();
			}
		});
		t.start();

	}

	public void init(){
		player = new Player(this);
		peopleList.add(player);
		dim = Toolkit.getDefaultToolkit().getScreenSize();
	}

	public void update(){

		for(Person p : peopleList){
			System.out.println("shooting = "+ player.shooting);
			p.update();

		}

		boolean playWalk = false;

		if(player.stepDelay < 0){
			if(player.dirs[player.right]){
				player.pos.x += 15;
				playWalk = true;
				player.stepDelay = 2.5;
			}
			if(player.dirs[player.left]){
				player.pos.x -= 15;
				playWalk = true;
				player.stepDelay = 2.5;
			}
			if(player.dirs[player.up]){
				player.pos.y -= 15;
				playWalk = true;
				player.stepDelay = 2.5;
			}
			if(player.dirs[player.down]){
				player.pos.y += 15;
				playWalk = true;
				player.stepDelay = 2.5;
			}
		}
		else{
			player.stepDelay--;
		}


		if(playWalk) player.playWalkSound();

	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//g.fillRect(x,y,15,15);

		for(Person p : peopleList){

			for(Bullet b : p.weaponList.get(p.curWeapon).bulletList){
				g.setColor(Color.red);
				g.fillRect(b.pos.x,b.pos.y, 10, 5 );
			}
		}

		g.drawImage(player.character,player.pos.x,player.pos.y,45/2,90/2,this);
	}


	public Image getImageResource(String name) {

		String url = ""+getClass().getResource(name);
		if (url.equals("null")||url==null) {
			System.out.println("DEBUG: image resource name: " + name);
			System.out.println("DEBUG: image resource url: " + url);
		}

		Image tbr = null;

		try {

			tbr = Toolkit.getDefaultToolkit().getImage(getClass().getResource(name));

			long startTime = System.currentTimeMillis();
			while (tbr.getWidth(this)<1 && System.currentTimeMillis() < startTime + 5000) {}

		} catch (Exception e) {
			System.out.println("Exception thrown for image " + name + ": ");
			e.printStackTrace();
		}

		return tbr;
	}

	public Point getMouseLocation(){
		return mouseP;
	}



}