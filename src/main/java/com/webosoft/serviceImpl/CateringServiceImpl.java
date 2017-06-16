package com.webosoft.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.webosoft.dao.CateringDAO;
import com.webosoft.services.CateringService;

@Service
public class CateringServiceImpl implements CateringService {

	@Autowired
	CateringDAO cateringDAO;

	public Object getCaters(BasicDBObject searchParams) {
		// TODO Auto-generated method stub
		return cateringDAO.searchCaters(searchParams);
	}

	public Object getCatersDetail(BasicDBObject filterDTO) {
		// TODO Auto-generated method stub
		return cateringDAO.getCatersDetail(filterDTO);
	}
}
