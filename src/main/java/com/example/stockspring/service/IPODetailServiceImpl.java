package com.example.stockspring.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stockspring.dao.IPODetailDao;
import com.example.stockspring.model.IPODetail;


@Service
public class IPODetailServiceImpl implements IPODetailService {

	@Autowired
	private IPODetailDao ipodao;
	
	
	public void insertIPODetail(IPODetail ipo) throws SQLException {
		ipodao.save(ipo);
			}

}
