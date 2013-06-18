import java.awt.Rectangle;
import java.awt.*;

public class Player extends Person{
//int
	int x = 0;
	int y = 0;
	final int left = 0, right = 1, up = 2, down = 3;
	int playerHeight;
	int playerWidth;


//double
	double stepDelay = 2.5;

//boolean
	boolean dirs[] = new boolean[4];
	boolean playWalk;
	boolean shooting = false;

//sound
	private Sound walk = new Sound("SoundFX/walk.wav");

//Image
	Image character;

//GetImage
	getImage getImg = new getImage();

//Point
	Point mouseP;

	public Player(){
		super("Dallas", 100, 100, new Rectangle(), 150);
		pos = new Point(0,0);

		init();
	}

	public Player(SpencerGame game){
		super("Dallas", 100, 100, new Rectangle(), 150);
		pos = new Point(0,0);
		this.game = game;

		init();
	}

	public void init(){

		character = getImg.getImageResource("Images/character.png");
		playerHeight = character.getHeight(getImg);
		playerWidth = character.getWidth(getImg);

	}

	public void playWalkSound(){
		walk.play();
	}

	public void update(){
		mouseP = game.getMouseLocation();
		System.out.println("updating");
		if(shooting){
			System.out.println("adding bullet");

			Weapon tempWeapon = weaponList.get(curWeapon);
			Point tempPos = new Point(pos.x+character.getWidth(getImg)/2, pos.y+character.getHeight(getImg)/2);
			//Point tempPos = new Point(pos.x,pos.y);

			tempWeapon.bulletList.add(new Bullet(tempWeapon.strength, (( mouseP.x - pos.x) / tempWeapon.speed), (( mouseP.y - pos.y ) / tempWeapon.speed), tempPos));
			//weaponList.get(curWeapon).fire();
		}

		for(Bullet b : weaponList.get(curWeapon).bulletList){
			b.update();
		}

	}

	public static void main(String[]args){
		new SpencerGame();
	}



}