package com.lawencon.covid.dao;

import java.util.List;
import java.util.Map;

import com.lawencon.covid.model.Covid;

public interface CovidDao {
	
	abstract void insertCovid(Covid covid) throws Exception;
	abstract List<Covid> viewCovid() throws Exception;
	abstract Covid findByIdCovid(Covid covid) throws Exception;
	abstract void updateCovid(Covid covid) throws Exception;
	abstract void deleteCovid(Covid covid) throws Exception;
	abstract List<Map<String, Object>> viewTotal() throws Exception;
}
