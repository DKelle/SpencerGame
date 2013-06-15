import java.util.ArrayList;
import java.awt.Rectangle;

public abstract class Person{

//int
	int money;

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
	Weapon	curWeapon;


	public Person(String name,int money, double health, Rectangle hitbox, double maxHealth){
		potionList = new ArrayList<Potion>();
		this.name = name;
		this.money = money;
		this.health = health;
		this.hitbox = hitbox;
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



}