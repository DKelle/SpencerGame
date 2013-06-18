
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class getImage extends JPanel{
	public getImage(String name){
		getImageResource(name);
	}

	public getImage(){

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
}