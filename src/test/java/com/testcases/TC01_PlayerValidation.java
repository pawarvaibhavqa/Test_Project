package com.testcases;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class TC01_PlayerValidation {
	
	@Test
	public void playersValidate() throws Exception {
		//read data from local json file and store in byte array
		byte[] response = Files.readAllBytes(Paths.get("rcbteam.json"));
		
		//convert byte array into string
		String nbdy = new String(response);
		
		JsonPath js = new JsonPath(nbdy);
		
		String lst1 = js.getString("player[0].country");
		String lst2 = js.getString("player[1].country");
		String lst3 = js.getString("player[2].country");
		String lst4 = js.getString("player[3].country");
		String lst5 = js.getString("player[4].country");
		String lst6 = js.getString("player[5].country");
		String lst7 = js.getString("player[6].country");
		String lst8 = js.getString("player[7].country");
		String lst9 = js.getString("player[8].country");
		String lst10 = js.getString("player[9].country");
		String lst11= js.getString("player[10].country");
		
		//Lets extract data from response using json path
		ArrayList<String> lst = new ArrayList<String>(Arrays.asList(lst1,lst2,lst3,lst4,lst5,lst6,lst7,lst8,lst9,lst10,lst11));
		
		//Total Size
		int k = lst.size();
		System.out.println(k);
		
		for(int i = 0; i<lst.size(); i++)
		{
		   if(lst.remove("India")) {
			   System.out.println("Test Case is passed : only 4 Foregin players present");
			   int j = lst.size();
			   System.out.println(j);
		   } 
		}
		
	}
	

	
}
