package screens;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;


import com.pong.PongGame;


public class HowTo implements Screen {

	public static final int PLAY_BUTTON_WIDTH = 248;
	public static final int PLAY_BUTTON_HEIGHT = 46;
	
	public static final int PLAY_BUTTON_Y = 25;
	
	Texture playButtonActive;
	Texture playButtonInactive;
	
	private BitmapFont font;
	
	PongGame game;
	
	public HowTo(PongGame game) {
		this.game = game;
		
		playButtonActive = new Texture(Gdx.files.internal("data/play_button_active.png"));
		playButtonInactive = new Texture(Gdx.files.internal("data/play_button_inactive.png"));
		
		font = new BitmapFont(Gdx.files.internal("data/HowToFont/HowToFont.fnt"), false);
	}

	@Override
	public void show() {
		
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		game.batch.begin();
		
		int x = PongGame.WIDTH - PLAY_BUTTON_WIDTH - 10;
		
		font.draw(game.batch, "To move up and down use the UP and DOWN keys.", 5, PongGame.HEIGHT - 10);
		font.draw(game.batch, "The Speed counter rises and the game gets", 5, PongGame.HEIGHT - 80);
		font.draw(game.batch, "faster.", 5, PongGame.HEIGHT - 110);
		
		font.draw(game.batch, "Last long enough and the PC will get LOCKED", 5, PongGame.HEIGHT - 180);
		font.draw(game.batch, "and can't move.", 5, PongGame.HEIGHT - 210);
		
		font.draw(game.batch, "The first to 11 wins! Have Fun!", 5, PongGame.HEIGHT - 280);
		
		// font.draw(game.batch, "There is one Easter Egg in this game!", 5, PongGame.HEIGHT - 350);
		// font.draw(game.batch, "Can you find it?", 5, PongGame.HEIGHT - 380);

		if (Gdx.input.getX() < x + PLAY_BUTTON_WIDTH && Gdx.input.getX() > x && PongGame.HEIGHT - Gdx.input.getY() < PLAY_BUTTON_Y + PLAY_BUTTON_HEIGHT && PongGame.HEIGHT - Gdx.input.getY() > PLAY_BUTTON_Y) {
			

			game.batch.draw(playButtonActive, x, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
			if (Gdx.input.isTouched()) {
				this.dispose();
				game.setScreen(new MainGameScreen(game));
			}
		} 
		
		else {
			game.batch.draw(playButtonInactive, x, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
		}
		
		game.batch.end();
		
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		
	}

}
