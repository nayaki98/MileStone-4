package com.example.stockspring.service;

import java.sql.SQLException;

import com.example.stockspring.model.IPODetail;

public interface IPODetailService {

	public void insertIPODetail(IPODetail ipo) throws SQLException;

}
