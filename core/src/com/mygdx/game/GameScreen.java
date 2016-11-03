package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ApplicationAdapter {
	SpriteBatch batch;
	Texture mccree;
	Texture mccree2;
	Texture bg;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		bg = new Texture("bg.jpg");
		mccree = new Texture("Mccree.png");
		mccree2 = new Texture("Mccree2.png");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(bg, 0, 0);
		batch.draw(mccree, 0, 0);
		batch.draw(mccree2, 1320, 0);
		batch.end();
	}
	
}