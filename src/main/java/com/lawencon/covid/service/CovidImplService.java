package com.lawencon.covid.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.covid.dao.CovidDao;
import com.lawencon.covid.model.Covid;

@Service
@Transactional
public class CovidImplService implements CovidService {

	@Autowired
	private CovidDao covid_dao;

	@Override
	public String insertCovid(Covid covid) throws Exception {
		covid_dao.insertCovid(covid);
		return "Berhasil";
	}

	@Override
	public List<Covid> viewCovid() throws Exception {
		return covid_dao.viewCovid();
	}

	@Override
	public String updateCovid(Covid covid) throws Exception {
		Covid covid2 = null;
		try {
			covid2 = covid_dao.findByIdCovid(covid);
		} catch (Exception e) {
		}
		if (covid2 != null) {
			covid2.setNamaKota(covid.getNamaKota());
			covid2.setKasusNegatif(covid.getKasusNegatif());
			covid2.setKasusPositif(covid.getKasusPositif());
			covid2.setKasusSembuh(covid.getKasusSembuh());
			covid2.setKasusMati(covid.getKasusMati());
			covid_dao.updateCovid(covid2);
			return "Berhasil";
		} else {
			return "Id kota tidak ada !";
		}
	}

	@Override
	public String deleteCovid(Covid covid) throws Exception {
		Covid covid2 = null;
		try {
			covid2 = covid_dao.findByIdCovid(covid);
		} catch (Exception e) {
		}
		if (covid2 != null) {
			covid_dao.deleteCovid(covid2);
			return "Berhasil";
		} else {
			return "Id kota tidak ada !";
		}
	}

	@Override
	public List<Map<String, Object>> viewsTotal() throws Exception {
		return covid_dao.viewTotal();
	}

}
