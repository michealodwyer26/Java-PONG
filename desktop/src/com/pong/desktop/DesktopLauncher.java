package com.pong.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.pong.PongGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.foregroundFPS = 60;
		config.width = PongGame.WIDTH;
		config.height = PongGame.HEIGHT;
		config.resizable = false;
		config.title = "Java PONG";
		new LwjglApplication(new PongGame(), config);

	}
}
