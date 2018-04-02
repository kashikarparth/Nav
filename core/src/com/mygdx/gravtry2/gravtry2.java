package com.mygdx.gravtry2;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class gravtry2 extends Game {
	public SpriteBatch batch;
	public static final float PPM = 100;
	Preferences prefs;
	public Music music;

	@Override
	public void create () {

		batch = new SpriteBatch();
		prefs = Gdx.app.getPreferences("Gravtry Preferences");

		prefs.putInteger("score", prefs.getInteger("score"));

		prefs.putInteger("coins", prefs.getInteger("coins"));

		prefs.putInteger("level1", prefs.getInteger("level1"));
		prefs.putInteger("level2", prefs.getInteger("level2"));
		prefs.putInteger("level3", prefs.getInteger("level3"));
		prefs.putInteger("level4", prefs.getInteger("level4"));
		prefs.putInteger("level5", prefs.getInteger("level5"));
		prefs.putInteger("level6", prefs.getInteger("level6"));

		prefs.putInteger("currlevel", 0);
		prefs.putInteger("currsprite", 1);
		prefs.putInteger("currscore", 0);
		prefs.putInteger("currfollow", 0);

		prefs.putInteger("sprite1", 1);
		prefs.putInteger("sprite2", prefs.getInteger("sprite2"));
		prefs.putInteger("sprite3", prefs.getInteger("sprite3"));
		prefs.putInteger("sprite4", prefs.getInteger("sprite4"));
		prefs.putInteger("sprite5", prefs.getInteger("sprite5"));
		prefs.putInteger("sprite6", prefs.getInteger("sprite6"));
		prefs.putInteger("sprite7", prefs.getInteger("sprite7"));
		prefs.putInteger("sprite8", prefs.getInteger("sprite8"));
		prefs.putInteger("sprite9", prefs.getInteger("sprite9"));

		prefs.putInteger("sound", 1);
		prefs.putInteger("shadows", 0);

		prefs.flush();

		setScreen(new MenuScreen(this));
		if(prefs.getInteger("sound") == 1) {
			music = Gdx.audio.newMusic(Gdx.files.internal("bgmus.mp3"));
			music.setLooping(true);
			music.setVolume(0.6f);
			music.play();
		}
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
