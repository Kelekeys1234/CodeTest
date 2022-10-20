package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dto.SurburbResponseDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@ContextConfiguration(classes = CodingTestApplication.class)
class CodingTestApplicationTests {
	
	   @Autowired
		private TestRestTemplate restTemplate;
	   
		 private String URL ="http://localhost:8081/api/v1";
		 private String PATH_SAPERATOR="/"; 
		 private String postCode="1234";
		 
		@Test
		void contextLoads() {
		}
	   
		@Test
		@DisplayName("saveSurburb")
		public void saveSurburb() throws URISyntaxException {
			String baseUrl =URL + PATH_SAPERATOR + "save";
			URI uri = new URI(baseUrl);
			SurburbResponseDto surburbResponseDto = new SurburbResponseDto();
			surburbResponseDto.setSurburbName(Arrays.asList("lekki","Victoria island","surulere"));
			surburbResponseDto.setPostCode("1234");
			List<SurburbResponseDto> Dto = Arrays.asList(surburbResponseDto);
			HttpHeaders headers = new HttpHeaders();
	        headers.set("X-COM-PERSIST", "true");      
	 
		    HttpEntity<List<SurburbResponseDto>> request = new HttpEntity<>(Dto, headers);
		    ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
		    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		         
	       	}
		 @Test
		 @DisplayName("getByPostCode")
		public void getSurburbByPostCode() throws URISyntaxException {
			String baseUrl =URL + PATH_SAPERATOR+"postCode"+"?postCode=1234";
			URI uri = new URI(baseUrl);
			Map<String,String> param = new HashMap<>();
			param.put("postCode", "1234");
			
	        HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
	
			HttpEntity<String> entity = new HttpEntity<>(null, headers);
			ResponseEntity<String> response =this.restTemplate.getForEntity(uri, String.class);
			assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		         
		}
}
