package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer.Random;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.math.MathUtils;

public class GameScreen extends ApplicationAdapter {
    public static final int WIDTH = 1920;
    public static final int HEIGHT = 800;
	SpriteBatch batch; 
	Texture mccree;
	Texture mccree2;
	Texture bg;
	Texture player1;
	Texture player2;
	Texture duel;
	Texture bq;
	Texture bw;
	Texture be;
	Texture ba;
	Texture bs;
	Texture bd;
	Texture b4;
	Texture b5;
	Texture b6;
	Texture b7;
	Texture b8;
	Texture b9;
    public static int winner;
    public static boolean trigger=true;
	int round=1;
    public static long time = System.currentTimeMillis();
    public static long randomNum = time+MathUtils.random(10000, 15000);
	int hp1=2;
	int hp2=2;
	int buttonP1 = MathUtils.random(1, 6);
	int buttonP2 = MathUtils.random(11, 16);


	Music themeSound;
	Music duelSound;
	static Sound gunSound;
	@Override
	public void create () {
		batch = new SpriteBatch();
		bg = new Texture("bg.jpg");
		mccree = new Texture("Mccree.png");
		mccree2 = new Texture("Mccree2.png");
		player1 = new Texture("player1win.png");
		player2 = new Texture("player2win.png");
		duel = new Texture("duel.png");
		bq = new Texture("q.png");
		bw = new Texture("w.png");
		be = new Texture("e.png");
		ba = new Texture("a.png");
		bs = new Texture("s.png");
		bd = new Texture("d.png");
		b4 = new Texture("4.png");
		b5 = new Texture("5.png");
		b6 = new Texture("6.png");
		b7 = new Texture("7.png");
		b8 = new Texture("8.png");
		b9 = new Texture("9.png");
		themeSound = Gdx.audio.newMusic(Gdx.files.internal("ThemeSong.mp3"));
		duelSound = Gdx.audio.newMusic(Gdx.files.internal("DuelSound.ogg"));
		gunSound = Gdx.audio.newSound(Gdx.files.internal("GunShot.wav"));
	}

	@Override
	public void render () {
		themeSound.play();
		themeSound.setVolume(1.0f);
        batch.begin();
		batch.draw(bg, 0, 0);
		batch.draw(mccree, 0, 0);
		batch.draw(mccree2, WIDTH-600, 0);
		GameMechanic.gunFire();
		duelTimer();
		drawWinner(winner);
		batch.end();
		

	}
	
	private void duelTimer(){
		if(System.currentTimeMillis()>=randomNum){
			batch.draw(duel,810,250);
	    	drawButton(buttonP1);
	    	drawButton(buttonP2);
			duelSound.play();
			if(System.currentTimeMillis()>=randomNum+2000){
				duelSound.stop();
			}
		}
	}
	
    private void drawWinner(int winner) {
        if(winner==1) {
    		batch.draw(player1, 538, 600);
        }
        if(winner==2) {
    		batch.draw(player2, 538, 600);
        }
    }
    


	private void drawButton(int num){
		int posX1 = 300;
		int posY1 = 500;
		int posX2 = WIDTH-300;
		int posY2 = 500;
		switch ( num )
		{
		     case 1
		      :     batch.draw(bq, posX1, posY1);
		            break;
		     case 2
		      :     batch.draw(bw, posX1, posY1);
		            break;
		     case 3
	          :     batch.draw(be, posX1, posY1);
	                break;
		     case 4
	          :     batch.draw(ba, posX1, posY1);
	                break;
		     case 5
	          :     batch.draw(bs, posX1, posY1);
	                break;
		     case 6
	          :     batch.draw(bd, posX1, posY1);
	                break;
		     case 11
	          :     batch.draw(b4, posX2, posY2);
	                break;
		     case 12
	          :     batch.draw(b5, posX2, posY2);
	                break;
		     case 13
	          :     batch.draw(b6, posX2, posY2);
	                break;
		     case 14
	          :     batch.draw(b7, posX2, posY2);
	                break;
		     case 15
	          :     batch.draw(b8, posX2, posY2);
	                break;
		     case 16
	          :     batch.draw(b9, posX2, posY2);
	                break;
		                		                		                
		     default
		          :     System.out.print ( "Error" );
		                break;
		}
		
	}
	
}