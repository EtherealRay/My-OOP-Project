package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ApplicationAdapter {
    public static final int WIDTH = 1920;
    public static final int HEIGHT = 800;
	SpriteBatch batch;
	Texture mccree;
	Texture mccree2;
	Texture bg;
	Texture player1;
	Texture player2;
	int winner;
	boolean trigger=true;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		bg = new Texture("bg.jpg");
		mccree = new Texture("Mccree.png");
		mccree2 = new Texture("Mccree2.png");
		player1 = new Texture("player1win.png");
		player2 = new Texture("player2win.png");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if(Gdx.input.isKeyPressed(Keys.D)&&trigger)
        {
        	winner=1;
        	trigger=false;
        }
        if(Gdx.input.isKeyPressed(Keys.L)&&trigger)
        {
        	winner=2;
        	trigger=false;
        }
		batch.begin();
		batch.draw(bg, 0, 0);
		batch.draw(mccree, 0, 0);
		batch.draw(mccree2, WIDTH-600, 0);
		duel(winner);
		batch.end();
	}
	
    private void duel(int winner) {
        if(winner==1) {
    		batch.draw(player1, 538, 600);
        }
        if(winner==2) {
    		batch.draw(player2, 538, 600);
        }
    }
	
}