import java.awt.Point;

public class Bullet {
//int
	int strength;

//Point
	Point pos;

//double
	double xVel;
	double yVel;

	public Bullet(int strength, double xVel, double yVel, Point pos){
		this.strength = strength;
		this.xVel = xVel;
		this.yVel = yVel;
		this.pos = pos;
	}


	public void update(){
		pos = new Point((int)(pos.getX()+xVel), (int)(pos.getY()+yVel));
	}
}