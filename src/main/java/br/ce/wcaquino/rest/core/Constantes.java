package br.ce.wcaquino.rest.core;

import io.restassured.http.ContentType;

public interface Constantes {
	
	String APP_BASE_URL = "http://barrigarest.wcaquino.me";
	Integer APP_PORT_HTTP = 80; 
	Integer APP_PORT_HTTPS = 443; 
	String APP_BASE_PATH = "";
	
	ContentType APP_CONTENT_TYPE = ContentType.JSON;
	Long MAX_TIMOUT = 5000L;
	
}
