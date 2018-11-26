package com.cos.sky.util;

/* Java 샘플 코드 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ApiExplorer {
	public static String getAirportData(String depAirportId,
			String arrAirportId, String depPlandTime) throws IOException {
		// depAirportId = "NAARKSS";
		// arrAirportId = "NAARKPC";
		// depPlandTime = "20181127";
		StringBuilder urlBuilder = new StringBuilder(
				"http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList"); /* URL */
		urlBuilder
				.append("?"
						+ URLEncoder.encode("ServiceKey", "UTF-8")
						+ "=wJmmW29e3AEUjwLioQR22CpmqS645ep4S8TSlqtSbEsxvnkZFoNe7YG1weEWQHYZ229eNLidnI2Yt5EZ3Stv7g%3D%3D"); /*
																															 * Service
																																																							 */
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
				+ URLEncoder.encode("200", "UTF-8")); /* 한 페이지 결과 수 */
		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "="
				+ URLEncoder.encode("1", "UTF-8")); /* 페이지 번호 */
		urlBuilder.append("&" + URLEncoder.encode("depAirportId", "UTF-8")
				+ "=" + URLEncoder.encode(depAirportId, "UTF-8")); /* 출발공항ID */
		urlBuilder.append("&" + URLEncoder.encode("arrAirportId", "UTF-8")
				+ "=" + URLEncoder.encode(arrAirportId, "UTF-8")); /* 도착공항ID */
		urlBuilder.append("&" + URLEncoder.encode("depPlandTime", "UTF-8")
				+ "=" + URLEncoder.encode(depPlandTime, "UTF-8")); /* 출발일 */
		urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "="
				+ URLEncoder.encode("json", "UTF-8")); /* 출발일 */
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(
					new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		// System.out.println(sb.toString());
		return sb.toString();
	}

	public static List<AirVO> getAirportJson(String depAirportId,
			String arrAirportId, String depPlandTime) throws Exception {
		String result = getAirportData(depAirportId, arrAirportId, depPlandTime);
		// Json처럼 생긴 String을 Json으로 만들기
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = (JSONObject) parser.parse(result);
		// response
		JSONObject j_response = (JSONObject) jsonObj.get("response");
		// System.out.println(j_response);
		JSONObject j_body = (JSONObject) j_response.get("body");
		JSONObject j_items = (JSONObject) j_body.get("items");
		JSONArray a_item = (JSONArray) j_items.get("item");
		a_item.remove(0);
		// System.out.println(a_item);

		// GSON을 -> 클래스로 - AirVO
		// GSON을 -> 배열로 - List<AirVO>
		Gson gson = new Gson();
		// gson.fromJson(j_items.toString(), AirVO.class);
		List<AirVO> list =
				gson.fromJson(a_item.toString(), 
						new TypeToken<List<AirVO>>(){}.getType());
		
		for (AirVO airVO : list) {
			System.out.println(airVO.getArrPlandTime());
		}
		return list;
		//
		// AirVO[] arr =
		// gson.fromJson(a_item.toString(), AirVO[].class);

	}
}