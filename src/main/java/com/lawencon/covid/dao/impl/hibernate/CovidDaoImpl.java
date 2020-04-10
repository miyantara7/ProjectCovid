package com.lawencon.covid.dao.impl.hibernate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.covid.dao.CovidDao;
import com.lawencon.covid.model.Covid;

@Repository
public class CovidDaoImpl extends BaseHibernate implements CovidDao{

	@Override
	public void insertCovid(Covid covid) throws Exception {
		em.persist(covid);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Covid> viewCovid() throws Exception {
		Query q = em.createQuery("from Covid");
		return q.getResultList();
	}

	@Override
	public Covid findByIdCovid(Covid covid) throws Exception {
		Query q = em.createQuery("from Covid where covidId =: idParam")
				.setParameter("idParam", covid.getCovidId());
		return (Covid) q.getSingleResult();
	}

	@Override
	public void updateCovid(Covid covid) throws Exception {
		em.persist(covid);
	}

	@Override
	public void deleteCovid(Covid covid) throws Exception {
		em.remove(covid);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> viewTotal() throws Exception {
		Query q = em.createQuery("select sum(tc.kasusMati) , sum(tc.kasusSembuh) , "
				+ "sum(tc.kasusNegatif ) , "
				+ "sum(tc.kasusPositif)  "
				+ "from Covid tc");
		
		return bMapperHibernate(q.getResultList(), "TotalDeath","TotalSembuh","TotalNegatif","TotalPositif");
	}
	
	private static List<Map<String, Object>> bMapperHibernate(List<Object[]> listMapping, String... obj) throws Exception {
		if(listMapping.isEmpty() || listMapping.get(0).length < 1) throw new Exception("Results is Empty");		
		if(listMapping.get(0).length != obj.length) throw new Exception("Length not same, results = "+listMapping.get(0).length+" <> mapping = "+obj.length);
		
		List<Map<String, Object>> listMap = new ArrayList<>();
		listMapping.forEach(valObj -> {
			Map<String, Object> map = new HashMap<String, Object>();
			for (int i = 0; i < valObj.length; i++) {
				map.put(obj[i], valObj[i]);
			}
			
			listMap.add(map);
		});
		
		return listMap;
	}

	
	
}
