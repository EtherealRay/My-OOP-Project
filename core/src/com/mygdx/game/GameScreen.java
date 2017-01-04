package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer.Random;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.math.MathUtils;

public class GameScreen extends ApplicationAdapter {
    public static final int WIDTH = 1920;
    public static final int HEIGHT = 800;
	static SpriteBatch batch; 
	Texture mccree,mccree2;
	Texture bg;
	Texture player1,player2;
	static Texture duel;
	static Texture bq,bw,be,ba,bs,bd,b4,b5,b6,b7,b8,b9;
	static Texture MccreeSheet,MccreeSheet2;
    public static int winner;
    public static boolean trigger=true;
    public static long time = System.currentTimeMillis();
    public static long randomNum = time+MathUtils.random(10000, 15000)+5000;
    public static final int buttonP1 = MathUtils.random(1, 6);
    public static final int buttonP2 = MathUtils.random(11, 16);
    TextureRegion[] animationFrames,animationFrames2;
    Animation animation,animation2;
    float elapsedTime;
	Music themeSound,endSound;
	static Music duelSound;
	static Sound gunSound;
	static Sound gunFire;
	boolean end = false;
	@Override
	public void create () {
		batch = new SpriteBatch();
		bg = new Texture("bg.jpg");
		mccree = new Texture("Mccree.png");
		mccree2 = new Texture("Mccree2.png");
		player1 = new Texture("player1win.png");
		player2 = new Texture("player2win.png");
		duel = new Texture("duel.png");
		bq = new Texture("Q.png");
		bw = new Texture("W.png");
		be = new Texture("E.png");
		ba = new Texture("A.png");
		bs = new Texture("S.png");
		bd = new Texture("D.png");
		b4 = new Texture("4.png");
		b5 = new Texture("5.png");
		b6 = new Texture("6.png");
		b7 = new Texture("7.png");
		b8 = new Texture("8.png");
		b9 = new Texture("9.png");
		MccreeSheet = new Texture("MccreeSheet.png");
		MccreeSheet2 = new Texture("MccreeSheet2.png");
		TextureRegion[][] tmpFrames = TextureRegion.split(MccreeSheet,288,288);
		TextureRegion[][] tmpFrames2 = TextureRegion.split(MccreeSheet2,288,288);
	    animationFrames = new TextureRegion[7];
	    animationFrames2 = new TextureRegion[7];
	    int index = 0;
	    int index2 = 0;
	      for (int i = 0; i < 1; i++){
	          for(int j = 0; j < 7; j++) {
	             animationFrames[index++] = tmpFrames[i][j];
	             animationFrames2[index2++] = tmpFrames2[i][j];
	          }
	       }
	    animation = new Animation(1f/6f,animationFrames);
	    animation2 = new Animation(1f/6f,animationFrames2);
	    elapsedTime = 0f;
	    
		themeSound = Gdx.audio.newMusic(Gdx.files.internal("ThemesSong2.mp3"));
		endSound = Gdx.audio.newMusic(Gdx.files.internal("VictorySong.mp3"));
		duelSound = Gdx.audio.newMusic(Gdx.files.internal("DuelSound.ogg"));
		gunSound = Gdx.audio.newSound(Gdx.files.internal("GunShot.wav"));
	}

	@Override
	public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT); 
	    elapsedTime += Gdx.graphics.getDeltaTime();
		themeSound.play();
		themeSound.setVolume(0.6f);
		if(end){
			themeSound.dispose();
			endSound.play();
		}
        batch.begin();
		batch.draw(bg, 0, 0);
        batch.draw(animation.getKeyFrame(elapsedTime,true),150,200);
        batch.draw(animation2.getKeyFrame(elapsedTime,true),WIDTH-450,200);
		GameMechanic.gunFire();
		GameMechanic.duelTimer();
		drawWinner(winner);
		batch.end();
	}
	

	
    private void drawWinner(int winner) {
        if(winner==1) {
    		batch.draw(player1, 538, 600);
    		end = true;
        }
        if(winner==2) {
    		batch.draw(player2, 538, 600);
    		end = true;
        }
    }
    


	public static void drawButton(int num){
		int posX1 = 250;
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
