package com.spring.board;

import org.junit.Test;

public class MakeYoutube {
	final String URL1 = "https://youtu.be/uFJGdUeC2pk";
	final String URL2 = "https://www.youtube.com/watch?v=uFJGdUeC2pk";
	String myParse = "https://www.youtube.com/embed/";
	
	@Test
	public void makeParsing(){
		youtubeTest(URL2);
	}
	
	
	public void youtubeTest(String url){
		String parsing = "";
		if(url.contains("=")){
			int index = url.indexOf("=");
			parsing = url.substring(index+1);
			System.out.println(parsing);
		}else{
			int index = url.lastIndexOf("/");
			parsing = url.substring(index+1);
			System.out.println(parsing);
		}
		
		myParse = myParse + parsing;
		System.out.println(myParse);
	}
}
