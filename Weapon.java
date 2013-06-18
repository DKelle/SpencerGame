import java.awt.Rectangle;
import java.util.ArrayList;

public abstract class Weapon{
//String
	String name;

//int
	int strength;
	int speed; //the higher the slower

//double


//boolean
	boolean rapidFire;

//Person
	Person person;
//ArrayList
	ArrayList<Bullet> bulletList = new ArrayList<Bullet>();

	public Weapon(){

	}

	public abstract void fire();
}