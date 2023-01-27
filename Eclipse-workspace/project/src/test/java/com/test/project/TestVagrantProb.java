package com.test.project;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

public class TestVagrantProb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 JSONParser parser = new JSONParser();
	        try {     
	            Object obj = parser.parse(new FileReader("RCB.json"));
	            JSONObject jsonObject =  (JSONObject) obj;

	            // loop array
	            int countOfForeignPlayers = 0;
	            int countOfWicketKeepers = 0;
	            JSONArray players = (JSONArray) jsonObject.get("player");
	            for (int j = 0; j < players.size();j++){
	                JSONObject playersJSONObject = (JSONObject) players.get(j);
	               String country = (String) playersJSONObject.get("country");
	               String role = (String) playersJSONObject.get("role");
	              if(!country.equalsIgnoreCase("india"))
	            	  countOfForeignPlayers++;
	              if(role.equalsIgnoreCase("Wicket-keeper"))
	            	  countOfWicketKeepers++;
	            }
	            System.out.println(countOfForeignPlayers);
	            System.out.println(countOfWicketKeepers);
	            Assert.assertTrue(countOfForeignPlayers==4);
	            Assert.assertTrue(countOfWicketKeepers>=1);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	    }

}
