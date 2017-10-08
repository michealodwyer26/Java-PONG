package entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.audio.Sound;

import java.util.Random;

import com.pong.PongGame;

public class Ball {
	
	public static Random random;
	public int X_SPEED;
	public int Y_SPEED;
	
	public int WIDTH;
	public int HEIGHT;
	
	public float x, y;

	private Texture texture;
	
	public Sound bounceSound;
	public Sound rallySound;
	
	public Ball() {
		random = new Random();
		
		X_SPEED = random.nextBoolean() ? 240 : -240; // Pick either 240 or -240
		Y_SPEED = random.nextBoolean() ? random.nextInt(60) + 30 : -random.nextInt(60) - 30 ; // Pick from 30 to 90 or -90 to-30
		
		x = Gdx.graphics.getWidth()/2 - this.WIDTH/2;
		y = Gdx.graphics.getHeight()/2 - this.HEIGHT/2;
		
		WIDTH = 10;
		HEIGHT = 10;
		
		texture = new Texture(Gdx.files.internal("data/ball.png"));
		
		bounceSound = Gdx.audio.newSound(Gdx.files.internal("data/audio2.wav"));
		rallySound = Gdx.audio.newSound(Gdx.files.internal("data/audio3.wav"));
	}
	
	public void update(float deltaTime, Rectangle[] PaddleRectangles, Rectangle GameBallRect, Paddle paddle, PongGame game) {
		this.x += this.X_SPEED * deltaTime;
		this.y += this.Y_SPEED * deltaTime;
		
		// Update GameBallRect x, y values
		GameBallRect.x = this.x;
		GameBallRect.y = this.y;
		
		// Bounce code
		
		// -- Bounced off the top of the window
		if (this.y + this.HEIGHT > Gdx.graphics.getHeight()) { 
			this.bounce(paddle, game);
		}
		
		// -- Bounced of the bottom of the window
		if (y < 0) {
			this.bounce(paddle, game);
		}
		
		
		
		// Rally code
		for (Rectangle PaddleRectangle : PaddleRectangles) {
			
			if (Intersector.overlaps(PaddleRectangle, GameBallRect)) {
				this.X_SPEED *= -1.1;
				this.Y_SPEED *= 1.1;
				paddle.speed *= 1.1;
				game.speed += 1;
				rallySound.play();
			}
		}
	}
	
	public void render(SpriteBatch batch) {
		batch.draw(texture, this.x, this.y);
	}
	
	private void bounce(Paddle paddle, PongGame game) {
		this.Y_SPEED *= -1.1;
		this.X_SPEED *= 1.1;
		paddle.speed *= 1.1;
		game.speed += 1;
		bounceSound.play();
	}
}
