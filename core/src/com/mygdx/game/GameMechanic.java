package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class GameMechanic {
	

   
	public static void gunFire(){

        if(Gdx.input.isKeyPressed(Keys.D)&&GameScreen.trigger&&System.currentTimeMillis()>=GameScreen.randomNum){
        	GameScreen.gunSound.play(0.5f);
        	GameScreen.winner=1;
        	GameScreen.trigger=false;
        }
        
        if(Gdx.input.isKeyPressed(Keys.L)&&GameScreen.trigger&&System.currentTimeMillis()>=GameScreen.randomNum){
        	GameScreen.gunSound.play(0.5f);
        	GameScreen.winner=2;
        	GameScreen.trigger=false;
        }
    }
	
	public static void duelTimer(){
		if(System.currentTimeMillis()>=GameScreen.randomNum){
			GameScreen.batch.draw(GameScreen.duel,810,250);
			GameScreen.drawButton(GameScreen.buttonP1);
			GameScreen.drawButton(GameScreen.buttonP2);
	    	GameScreen.duelSound.play();
			if(System.currentTimeMillis()>=GameScreen.randomNum+2000){
				GameScreen.duelSound.stop();
			}
		}
	}

}
