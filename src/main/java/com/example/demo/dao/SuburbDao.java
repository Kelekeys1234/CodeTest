package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.SurburbModel;

public interface SuburbDao {

	public SurburbModel saveSurburb(SurburbModel surburb);
	
	public List<SurburbModel> findAllBypostCode(List<String> postCode);
}
