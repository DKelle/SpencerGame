import java.util.ArrayList;
import java.awt.Point;

public class SimpleGun extends Weapon{
//ArrayList


//int
	int bulletXvel;
	int bulletYvel;

//Point
	Point pos;

	public SimpleGun(Person p){
		strength = 10;
		name = "Simple Gun";
		rapidFire = false;
		person = p;
		bulletXvel = 10;
		bulletYvel = 1;
		speed = 50;
	}

	public void fire(){
//		bulletXvel = (person.pos.x - person.mouseP.x) / (person.pos.y - person.mouseP.y);
//		bulletYvel = (person.pos.y - person.mouseP.y) / (person.pos.x - person.mouseP.x);

		try{

//			Point tempPos = new Point(pos.x+person.playerHeight/2, pos.y+person.playerWidth/2);
//			bulletList.add(new Bullet(strength, bulletXvel, bulletYvel, tempPos));


		}catch(Exception e){
			e.printStackTrace();
		}
	}
}