import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;



public class Sound
{
//        public static final Sound enemyHit = new Sound("/enemyHurt.wav", false);
//        public static final Sound explosion = new Sound("/Explosion.wav", false);
//        public static final Sound fShoot = new Sound("/FShoot.wav", false);
//        public static final Sound bShoot = new Sound("/BShoot.wav", false);
//        public static final Sound pShoot = new Sound("/PShoot.wav", false);
//
//        public static final Sound music = new Sound("/music.wav", true);

        private AudioClip clip;
        private boolean loop;

        public Sound(String name)
        {
			try
			{
				this.loop = loop;
				clip = Applet.newAudioClip(Sound.class.getResource(name));
			}
			catch(Throwable e)
			{
				e.printStackTrace();
			}
        }

        public void play()
        {
			try
			{
				new Thread()
				{
					@Override
					public void run()
					{
						if(loop)
							clip.loop();
						else
							clip.play();
					}
				}.start();
			}
			catch(Throwable e)
			{
				e.printStackTrace();
			}
        }

        public void loop(int repeatTime)
        {
        	System.out.println("test 1");

			Timer t = new Timer(repeatTime, new java.awt.event.ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					System.out.println("test 2");

					clip.play();
				}
			});

        	System.out.println("test 3");

			t.start();

        }


        public void stop()
        {
        	clip.stop();
        }



}
