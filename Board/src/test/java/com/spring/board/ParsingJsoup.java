package com.spring.board;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

public class ParsingJsoup {
	
	public String getYoutubeParse(String url){
		String result = "";
		String parsing = "";
		if(url.contains("=")){
			int index = url.indexOf("=");
			parsing = url.substring(index+1);
			//System.out.println(parsing);
		}else{
			int index = url.lastIndexOf("/");
			parsing = url.substring(index+1);
			//System.out.println(parsing);
		}
		
		result = result + parsing;
		//System.out.println(result);
		return result;
	}
	
	@Test
	public void parseTest(){
		String data = "<p>영상 주소</p><p><a href=\"https://www.youtube.com/watch?v=uFJGdUeC2pk\">https://www.youtube.com/watch?v=uFJGdUeC2pk</a>&nbsp;</p>";
		Document doc = Jsoup.parse(data);
		//System.out.println(doc);
		Elements a_tag = doc.select("a");
		int a_tagSize = a_tag.size();
		if(a_tagSize > 0){
			for(int i=0; i< a_tagSize; i++){
				if(a_tag.get(i).attr("href").contains("https://www.youtube.com") || a_tag.get(i).attr("href").contains("https://youtu.be")){
					//System.out.println("유투브 영상 링크가 존재합니다.");
					String href = a_tag.get(i).attr("href");
					String result = getYoutubeParse(href);
					String iFrame = "<iframe id=\"player\" type=\"text/html\" width=\"90%\" height=\"409\" src=\"http://www.youtube.com/embed/"+result+"\" frameborder=\"0\" webkitallowfullscreen=\"\" mozallowfullscreen=\"\" allowfullscreen=\"\"></iframe>";
					a_tag.get(i).after(iFrame);
				}
			}
		}
		System.out.println(doc);
	}
	
}
