package com.example.demo.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.SuburbDao;
import com.example.demo.model.SurburbModel;
import com.example.demo.repository.SurburbRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SurburbDaoImpl implements SuburbDao {
	@Autowired
	private SurburbRepository surburbRepository;

	@Override
	public SurburbModel saveSurburb(SurburbModel surburb) {
		log.info("saving surbub into the database");
		return surburbRepository.save(surburb);
	}

	@Override
	public List<SurburbModel> findAllBypostCode(List<String> postCode) {
		return surburbRepository.findAllByPostCodeInOrderBySuburbName(postCode);

	}
}
