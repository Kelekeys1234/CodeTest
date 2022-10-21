package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.xml.bind.ValidationException;
import com.example.demo.dto.SurburbResponseDto;
import com.example.demo.endPoint.SurburbEndPoint;
import com.example.demo.processor.SurburbProcessor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SurburbController implements SurburbEndPoint {
	@Autowired
	private SurburbProcessor surburbProcessor;

	@Override
	public ResponseEntity<String> saveSurburb(@RequestBody List<SurburbResponseDto> surburbDtos)
			throws ValidationException {
		log.info("putting surburbDto inside surburb processsor");
		surburbProcessor.saveSurburb(surburbDtos);
		return new ResponseEntity<>("result successful result", HttpStatus.OK);
	}

	@Override
	public List<SurburbResponseDto> getSurburbByPostCode(List<String> postCode) throws ValidationException {
		return surburbProcessor.getSurburbByPostCode(postCode);

	}
}
