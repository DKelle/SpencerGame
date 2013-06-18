import java.util.ArrayList;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.Image;

public abstract class Person{
//boolean
	boolean shooting = false;

//int
	int money;
	int curWeapon = 0;
	int personHeight;
	int personWidth;

//String
	String name;

//double
	double health;
	double maxHealth;

//ArrayList
	ArrayList<Potion> potionList;
	ArrayList<Weapon> weaponList;

//Rectangle
	Rectangle hitbox;

//Weapon
//	Weapon	curWeapon;

//Point
	Point pos;
	Point mouseP;

//Image
	Image character;

//SpencerGame
	SpencerGame game;


	public Person(String name,int money, double health, Rectangle hitbox, double maxHealth){
		potionList = new ArrayList<Potion>();
		weaponList = new ArrayList<Weapon>();
		weaponList.add(new SimpleGun(this));
		this.name = name;
		this.money = money;
		this.health = health;
		this.hitbox = hitbox;
	}

	public Person(String name,int money, double health, Rectangle hitbox, double maxHealth, SpencerGame game){
		potionList = new ArrayList<Potion>();
		weaponList = new ArrayList<Weapon>();
		weaponList.add(new SimpleGun(this));
		this.name = name;
		this.money = money;
		this.health = health;
		this.hitbox = hitbox;
		this.game = game;
	}

	public String getName(){
		return name;
	}
	public double getHealth(){
		return health;
	}
	public int getMoney(){
		return money;
	}

	public void lowerHealth(double damage)
	{
		health -= damage;
	}
	public void regainHealth(double regain){
		health += regain;
		if(health > maxHealth) health = maxHealth;
	}

	public void addPotion(Potion p){
		potionList.add(p);
	}
	public void usePotion(Potion p ){
		regainHealth(p.regainHealth);
		potionList.remove(p);
	}
	public void addWeapon(Weapon w){
		weaponList.add(w);
	}

	public void update(){
		mouseP = game.getMouseLocation();
		System.out.println("updating");
		if(shooting){
					System.out.println("adding bullet");

			Weapon temp = weaponList.get(curWeapon);
			weaponList.get(curWeapon).bulletList.add(new Bullet(temp.strength, 10, 10, pos));

		}

		for(Bullet b : weaponList.get(curWeapon).bulletList){
			b.update();
		}

	}





}