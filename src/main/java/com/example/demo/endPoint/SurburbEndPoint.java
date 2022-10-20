package com.example.demo.endPoint;

import java.util.List;

import javax.xml.bind.ValidationException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SurburbResponseDto;

@RestController
@RequestMapping(path="api/v1")
public interface SurburbEndPoint {
	@PostMapping("/save")
	public ResponseEntity<String> saveSurburb(@RequestBody List<SurburbResponseDto> surburbDto) throws ValidationException;
	
	@GetMapping(path="postCode")
	@ResponseBody
	public List<SurburbResponseDto> getSurburbByPostCode(@RequestParam(value="postCode") List<String> postCode) throws ValidationException;

	

}
