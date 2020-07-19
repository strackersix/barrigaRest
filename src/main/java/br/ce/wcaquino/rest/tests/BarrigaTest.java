package br.ce.wcaquino.rest.tests;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import br.ce.wcaquino.rest.core.BaseTest;

public class BarrigaTest extends BaseTest {


	@Test
	public void NaoDeveAcessarAPISemToken () {
		
		given()
		.when()
			.get("/contas")
		.then()
			.statusCode(401)
		
		;
		
	}

	@Test
	public void DeveIncluirContaComSucesso () {
		
		Map<String, String> login = new HashMap<String, String>();
		
		login.put("email", "gabriel_conrado_@hotmail.com");
		login.put("senha", "66238546");
		
		String token =
		
		given()
			.log().all()
			.body(login)
		.when()
			.post("/signin")
		.then()
			.statusCode(200)
			.extract().path("token")

		;
				
		given()
			.header("Authentication" , "bearer" + token)
			.body("{nome: \"conta qualquer\"}")
		.when()
			.log().all()
			.post("/contas")
						
		;
					
	}
	 


}
