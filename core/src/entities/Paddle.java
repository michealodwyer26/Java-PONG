package entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Rectangle;

import com.pong.PongGame;
public class Paddle {

	public final int WIDTH = 10;
	public final int HEIGHT = 50;
	public int speed = 240;
	
	public float x, y;
	
	private final boolean AI;
	public boolean locked;
	
	private static Texture texture;
	
	public Paddle(boolean ai) {
		this.AI = ai;
		
		if (AI) {
			this.x = Gdx.graphics.getWidth() - 25;
			this.y = Gdx.graphics.getHeight()/2 - this.HEIGHT/2;
		} else {
			this.x = 25;
			this.y = Gdx.graphics.getHeight()/2 - this.HEIGHT/2;

		}
		
		
		if (texture == null) {
			texture = new Texture(Gdx.files.internal("data/paddle.png"));
		}
	}
	
	public void update(float deltaTime, Rectangle[] paddleRectangles, Ball GameBall, PongGame game) {
		
		if (!AI) {
			if (Gdx.input.isKeyPressed(Keys.UP)) {
				this.y += this.speed * Gdx.graphics.getDeltaTime();
				
				if (this.y + this.HEIGHT > PongGame.HEIGHT) {
					this.y = PongGame.HEIGHT - this.HEIGHT;
				}
				
				
			}
			
			if (Gdx.input.isKeyPressed(Keys.DOWN)){
				this.y -= this.speed * deltaTime;
				
				if (this.y < 0) {
					this.y = 0;
				}
				
			}
			
		} else {
			// AI Code
			if (GameBall.X_SPEED > 0) { // BALL IS TRAVELLING WEST
				
				//  Locked variable
				if (game.speed >= 15) {
					this.locked = true;
					
					if (locked) {
						;
					}
				}
				
				// Window boundaries
				else if (this.y < 0) {
					this.y = 0;
				}
				
				else if (this.y + this.HEIGHT > PongGame.HEIGHT) {
					this.y = PongGame.HEIGHT - this.HEIGHT;
				}
				
				else if (GameBall.Y_SPEED < 0) {
					// BALL TRAVELLING DOWN
					if (GameBall.y + GameBall.HEIGHT < this.y + this.HEIGHT - 15 && GameBall.y > this.y + 15) {
						; // NOOP - Ball is inside the two x's of the paddle aka "Locked-in"
					}
					
					else if (GameBall.y > this.y + this.HEIGHT - 15) {
						this.y += this.speed * deltaTime; // Move up a bit
					}
					
					else {
						this.y -= this.speed * deltaTime; // Chase the ball down the screen
					}
					
				}
				
				else if (GameBall.Y_SPEED > 0) {
					// BALL TRAVELLING UP
					if (GameBall.y + GameBall.HEIGHT < this.y + this.HEIGHT - 15 && GameBall.y > this.y + 15) {
						;
					}
					
					else if (GameBall.y + GameBall.HEIGHT < this.y + 15) {
						this.y -= this.speed * deltaTime; // Move down a bit
					}
					
					else {
						this.y += this.speed * deltaTime; // Chase the ball up the screen
					}
				}
			}
			
			else { // BALL IS TRAVELLING EAST
				;
			}
		}
	}
	
	public void render(SpriteBatch batch) {
		batch.draw(texture, this.x, this.y);
	}
	
	public static void updateRects(Paddle paddle, Rectangle rect) {
		rect.x = paddle.x;
		rect.y = paddle.y;
	}
}
