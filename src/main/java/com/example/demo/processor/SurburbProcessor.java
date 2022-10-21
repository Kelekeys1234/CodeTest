package com.example.demo.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.demo.dao.SuburbDao;
import com.example.demo.dto.SurburbResponseDto;
import com.example.demo.exception.ValidationException;
import com.example.demo.model.SurburbModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SurburbProcessor {
	@Autowired
	private SuburbDao surburbDao;

	public List<SurburbModel> saveSurburb(List<SurburbResponseDto> surburbDtos) throws ValidationException {
		List<SurburbModel> surburbModel = surburbDtos.stream()
				.map(e -> new SurburbModel(UUID.randomUUID(), e.getSurburbName(), e.getPostCode())).toList();
		log.info("saving surburb to database");
		surburbDao.saveSurburb(surburbModel);

		return surburbModel;

	}

	public List<SurburbResponseDto> getSurburbByPostCode(List<String> postCode) throws ValidationException {
		log.info("checking if post code exist in database");
		List<SurburbModel> surburbName = surburbDao.findAllBypostCode(postCode);
		List<SurburbResponseDto> surburbDto = new ArrayList<>();
		log.info("checking if post code is present in Database");
		if (!CollectionUtils.isEmpty(surburbName)) {
			log.info("finding the total number of surburb name characters ");
			Integer total = surburbName.stream().map(e -> e.getSuburbName().toString().length()).reduce(Integer::sum)
					.get();
			surburbDto = surburbName.stream()
					.map(e -> new SurburbResponseDto(e.getSuburbName(), e.getPostCode(), total)).toList();

		} else {
			log.error("post code do not exist in database {}");
			throw new ValidationException("post code do not exist in database");
		}

		return surburbDto;
	}

}
