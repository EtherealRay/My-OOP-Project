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
    

}
