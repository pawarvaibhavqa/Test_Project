package com.testcases;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class TC02_WicketKeeperValidation {

	@Test
	public void wicketKeeperValidate() throws Exception {
		
		//read data from local json file and store in byte array
		byte[] response = Files.readAllBytes(Paths.get("rcbteam.json"));
		
		//convert byte array into string
		String nbdy = new String(response);
		
		JsonPath js = new JsonPath(nbdy);
		
		//Lets extract data from response using json path
		String lst1 = js.getString("player[0].role");
		String lst2 = js.getString("player[1].role");
		String lst3 = js.getString("player[2].role");
		String lst4 = js.getString("player[3].role");
		String lst5 = js.getString("player[4].role");
		String lst6 = js.getString("player[5].role");
		String lst7 = js.getString("player[6].role");
		String lst8 = js.getString("player[7].role");
		String lst9 = js.getString("player[8].role");
		String lst10 = js.getString("player[9].role");
		String lst11= js.getString("player[10].role");
		
		//Lets extract data from response using json path
		ArrayList<String> lst = new ArrayList<String>(Arrays.asList(lst1,lst2,lst3,lst4,lst5,lst6,lst7,lst8,lst9,lst10,lst11));
		for(int i = 0; i<lst.size(); i++)
		{
		   if(lst.remove("Wicket-keeper")) {
			   System.out.println("Test Case is passed : only one wicket_keeper is present");
			   int j = lst.size();
			   System.out.println(j);
		   } 
		}
	}
}
