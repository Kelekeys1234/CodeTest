package com.example.demo.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.xml.bind.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import com.example.demo.dao.SuburbDao;
import com.example.demo.dto.SurburbResponseDto;
import com.example.demo.model.SurburbModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SurburbProcessor {
	@Autowired
	private SuburbDao surburbDao;
	
  public SurburbModel saveSurburb(SurburbResponseDto surburbDto) throws ValidationException  {
	  SurburbModel surburbModel= new SurburbModel();
      log.info("checking if surburbName and post code is empty or not");
	
		  surburbModel.setId(UUID.randomUUID().toString());
		  surburbModel.setSuburbName(surburbDto.getSurburbName());
		  surburbModel.setPostCode(surburbDto.getPostCode());
		  log.info("saving surburb to database");
		  surburbDao.saveSurburb(surburbModel);
	 
	  return surburbModel;
	  
  }
  public List<SurburbResponseDto> getSurburbByPostCode (List<String> postCode) throws ValidationException {
	  log.info("checking if post code exist in database");
	  List<SurburbModel> findByPostCode= surburbDao.findAllBypostCode(postCode); 
	  List<SurburbResponseDto> surburbDto = new ArrayList<>();
    
	  if(!ObjectUtils.isEmpty(findByPostCode)) {
		  log.info("finding the total number of surburb");
		 Integer total= findByPostCode.stream().map(e->e.getSuburbName().toString().length()).reduce(Integer::sum).get();
		  surburbDto=findByPostCode.stream().map(e-> new SurburbResponseDto(e.getSuburbName() , e.getPostCode(),total)).toList();
	
	  }
	  else {
		  log.error("post code do not exist in database");
		  throw new ValidationException("post code do not exist in database");
	  }
	  
 
     
      return surburbDto;
  }


}
