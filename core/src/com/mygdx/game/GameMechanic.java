package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class GameMechanic {
	

   
	public static void gunFire(){
		
		switch (GameScreen.buttonP1)
		{
		     case 1
	          :     if(Gdx.input.isKeyPressed(Keys.Q)&&GameScreen.trigger&&System.currentTimeMillis()>=GameScreen.randomNum){
	        	  gunHit1();
	          }
		            break;
		     case 2
	          :     if(Gdx.input.isKeyPressed(Keys.W)&&GameScreen.trigger&&System.currentTimeMillis()>=GameScreen.randomNum){
	        	  gunHit1();
	          }
		            break;
		     case 3
	          :     if(Gdx.input.isKeyPressed(Keys.E)&&GameScreen.trigger&&System.currentTimeMillis()>=GameScreen.randomNum){
	        	  gunHit1();
	          }
	                break;
		     case 4
	          :     if(Gdx.input.isKeyPressed(Keys.A)&&GameScreen.trigger&&System.currentTimeMillis()>=GameScreen.randomNum){
	        	  gunHit1();
	          }
	                break;
		     case 5
	          :     if(Gdx.input.isKeyPressed(Keys.S)&&GameScreen.trigger&&System.currentTimeMillis()>=GameScreen.randomNum){
	        	  gunHit1();
	          }
	                break;
		     case 6
	          :     if(Gdx.input.isKeyPressed(Keys.D)&&GameScreen.trigger&&System.currentTimeMillis()>=GameScreen.randomNum){
	        	  gunHit1();
	          }
	                break;   		                
		     default
		          :     System.out.print ( "Error" );
		                break;
		}
		
		switch (GameScreen.buttonP2)
		{
		     case 11
	          :     if(Gdx.input.isKeyPressed(Keys.NUMPAD_4)&&GameScreen.trigger&&System.currentTimeMillis()>=GameScreen.randomNum){
	        	  gunHit2();
	          }
		            break;
		     case 12
	          :     if(Gdx.input.isKeyPressed(Keys.NUMPAD_5)&&GameScreen.trigger&&System.currentTimeMillis()>=GameScreen.randomNum){
	        	  gunHit2();
	          }
		            break;
		     case 13
	          :     if(Gdx.input.isKeyPressed(Keys.NUMPAD_6)&&GameScreen.trigger&&System.currentTimeMillis()>=GameScreen.randomNum){
	        	  gunHit2();
	          }
	                break;
		     case 14
	          :     if(Gdx.input.isKeyPressed(Keys.NUMPAD_7)&&GameScreen.trigger&&System.currentTimeMillis()>=GameScreen.randomNum){
	        	  gunHit2();
	          }
	                break;
		     case 15
	          :     if(Gdx.input.isKeyPressed(Keys.NUMPAD_8)&&GameScreen.trigger&&System.currentTimeMillis()>=GameScreen.randomNum){
	        	  gunHit2();
	          }
	                break;
		     case 16
	          :     if(Gdx.input.isKeyPressed(Keys.NUMPAD_9)&&GameScreen.trigger&&System.currentTimeMillis()>=GameScreen.randomNum){
	        	  gunHit2();
	          }
	                break;   		                
		     default
		          :     System.out.print ( "Error" );
		                break;
		}

    }
	
	public static void gunHit1(){
    	GameScreen.gunSound.play(0.5f);
    	GameScreen.winner=1;
    	GameScreen.trigger=false;
	}
	
	public static void gunHit2(){
    	GameScreen.gunSound.play(0.5f);
    	GameScreen.winner=2;
    	GameScreen.trigger=false;
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
