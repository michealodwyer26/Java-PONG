package com.pong;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.Gdx;

import screens.MainMenuScreen;

public class PongGame extends Game {
	
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	
	public int user_points = 0;
	public int pc_points = 0;
	
	public String user_points_string = "0";
	public String pc_points_string = "0";
	
	public int speed = 0;
	public String speed_string = "0";
	
	public SpriteBatch batch;
	public Music music;
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		this.setScreen((Screen) new MainMenuScreen(this));
	}
	
	@Override
	public void render() {
		super.render();
	}
}