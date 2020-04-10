package com.lawencon.covid.dao.impl.hibernate;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.covid.dao.UserDao;
import com.lawencon.covid.model.User;

@Repository
public class UserDaoImpl extends BaseHibernate implements UserDao{

	@Override
	public User findUser(User user) throws Exception {
		Query q = em.createQuery("from User where username =: userParam and password =: passParam")
				.setParameter("userParam", user.getUsername())
				.setParameter("passParam", user.getPassword());	
		return (User) q.getSingleResult();
	}

	
}
