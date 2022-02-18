package com.quyntess.service;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class MyCalcService {
	static String mathjsUrl = "http://api.mathjs.org/v4/?expr=";
	public String getResult (String myFormula) {
		try {
		System.out.println(myFormula);
	    URL url = new URL(mathjsUrl + URLEncoder.encode(myFormula, StandardCharsets.UTF_8));
	    System.out.println(url);
	    
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			
	
			String output=br.readLine();

			
		
			return output;
			
	        } catch (MalformedURLException e) {

	    		e.printStackTrace();
	    		return null;

	    	  } catch (IOException e) {

	    		e.printStackTrace();
	    		return null;

	    	  } 
	} 
	
}
