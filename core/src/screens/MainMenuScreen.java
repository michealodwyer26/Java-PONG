package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import com.pong.PongGame;
import com.badlogic.gdx.graphics.Texture;

public class MainMenuScreen implements Screen {
	
	public static final int PLAY_BUTTON_WIDTH = 248;
	public static final int PLAY_BUTTON_HEIGHT = 46;
	public static final int EXIT_BUTTON_WIDTH = 245;
	public static final int EXIT_BUTTON_HEIGHT = 44;
	public static final int HOW_TO_BUTTON_WIDTH = 246;
	public static final int HOW_TO_BUTTON_HEIGHT = 28;
	public static final int PLAY_BUTTON_Y = PongGame.HEIGHT/2 - PLAY_BUTTON_HEIGHT/2;
	public static final int EXIT_BUTTON_Y = PLAY_BUTTON_Y - PLAY_BUTTON_HEIGHT - 20;
	public static final int HOW_TO_BUTTON_Y = EXIT_BUTTON_Y - EXIT_BUTTON_HEIGHT - 15;

	PongGame game;

	Texture playButtonActive;
	Texture playButtonInactive;
	Texture exitButtonActive;
	Texture exitButtonInactive;
	Texture howToButtonActive;
	Texture howToButtonInactive;
	Texture titleImage;
	
	BitmapFont font;
	
	public MainMenuScreen(PongGame game) {
		this.game = game;
		
		playButtonActive = new Texture(Gdx.files.internal("data/play_button_active.png"));
		playButtonInactive = new Texture(Gdx.files.internal("data/play_button_inactive.png"));
		exitButtonActive = new Texture(Gdx.files.internal("data/quit_button_active.png"));
		exitButtonInactive = new Texture(Gdx.files.internal("data/quit_button_inactive.png"));
		howToButtonActive = new Texture(Gdx.files.internal("data/how_to_button_active.png"));
		howToButtonInactive = new Texture(Gdx.files.internal("data/how_to_button_inactive.png"));
		titleImage = new Texture(Gdx.files.internal("data/title_image.png"));
		
		font = new BitmapFont();
		
		// Reset game scores
		game.user_points = 0;
		game.pc_points = 0;
		
		game.user_points_string = "0";
		game.pc_points_string = "0";
		
	}

	@Override
	public void show() {
		
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		game.batch.begin();
		
		int x = PongGame.WIDTH/2 - EXIT_BUTTON_WIDTH/2;
		
		if (Gdx.input.getX() < x + EXIT_BUTTON_WIDTH && Gdx.input.getX() > x && PongGame.HEIGHT - Gdx.input.getY() < EXIT_BUTTON_Y + EXIT_BUTTON_HEIGHT && PongGame.HEIGHT - Gdx.input.getY() > EXIT_BUTTON_Y) {
			game.batch.draw(exitButtonActive, x, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
			if (Gdx.input.isTouched()) {
				Gdx.app.exit();
			}
			
		} else {
			game.batch.draw(exitButtonInactive, x, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
		
		}
		
		if (Gdx.input.getX() < x + PLAY_BUTTON_WIDTH && Gdx.input.getX() > x && PongGame.HEIGHT - Gdx.input.getY() < PLAY_BUTTON_Y + PLAY_BUTTON_HEIGHT && PongGame.HEIGHT - Gdx.input.getY() > PLAY_BUTTON_Y) {
			game.batch.draw(playButtonActive, x, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
			if (Gdx.input.isTouched()) {
				this.dispose();
				game.setScreen(new MainGameScreen(game));
				
				
			}
		} else {
			game.batch.draw(playButtonInactive, x, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);

		}
		
		if (Gdx.input.getX() < x + HOW_TO_BUTTON_WIDTH && Gdx.input.getX() > x && PongGame.HEIGHT - Gdx.input.getY() < HOW_TO_BUTTON_Y + HOW_TO_BUTTON_HEIGHT && PongGame.HEIGHT - Gdx.input.getY() > HOW_TO_BUTTON_Y) {
			game.batch.draw(howToButtonActive, x, HOW_TO_BUTTON_Y, HOW_TO_BUTTON_WIDTH, HOW_TO_BUTTON_HEIGHT);
			if (Gdx.input.isTouched()) {
				this.dispose();
				game.setScreen(new HowTo(game));
			}
		} else {
			game.batch.draw(howToButtonInactive, x, HOW_TO_BUTTON_Y, HOW_TO_BUTTON_WIDTH, HOW_TO_BUTTON_HEIGHT);
		}
		
		game.batch.draw(titleImage, PongGame.WIDTH/2 - titleImage.getWidth()/2, PongGame.HEIGHT - 125);
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
