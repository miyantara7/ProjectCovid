package com.lawencon.covid.service;

import java.util.List;
import java.util.Map;

import com.lawencon.covid.model.Covid;

public interface CovidService {

	abstract String insertCovid(Covid covid) throws Exception;
	abstract List<Covid> viewCovid() throws Exception;
	abstract String updateCovid(Covid covid) throws Exception;
	abstract String deleteCovid(Covid covid) throws Exception;
	abstract List<Map<String, Object>> viewsTotal() throws Exception;
}
