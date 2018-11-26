package com.cos.sky.util;

import java.util.HashMap;
import java.util.Map;

public class MyUtils {
	
	public static Map<String, String> getAirportId(){
		Map<String, String> result = 
				new HashMap<String, String>();
		result.put("무안", "NAARKJB");
		result.put("광주", "NAARKJJ");
		result.put("군산", "NAARKJK");
		result.put("여수", "NAARKJY");
		result.put("원주", "NAARKNW");
		result.put("양양", "NAARKNY");
		result.put("제주", "NAARKPC");
		result.put("김해", "NAARKPK");
		result.put("사천", "NAARKPS");
		result.put("울산", "NAARKPU");
		result.put("인천", "NAARKSI");
		result.put("김포", "NAARKSS");
		result.put("포항", "NAARKTH");
		result.put("대구", "NAARKTN");
		result.put("청주", "NAARKTU");
		
		return result;
	}
}
