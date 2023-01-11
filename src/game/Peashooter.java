package game;

import java.awt.image.BufferedImage;

public class Peashooter {
	//speed means how quickly they fire their respective projectile
	int cost, speed;
	BufferedImage img;
	
	Peashooter(){
		cost = 3;
		speed = 5;
		img = MainGame.loadImage("Photos/peashooter.png");
	}
}
