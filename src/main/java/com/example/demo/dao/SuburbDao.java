package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.SurburbModel;

public interface SuburbDao {

	public List<SurburbModel> saveSurburb(List<SurburbModel> surburb);

	public List<SurburbModel> findAllBypostCode(List<String> postCode);
}
