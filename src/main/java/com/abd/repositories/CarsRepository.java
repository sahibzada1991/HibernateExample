package com.abd.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ssd.entities.CarsEntity;

@Repository
public class CarsRepository {

	private SessionFactory sessionFactory;

	public void save(CarsEntity cars) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(cars);

		session.getTransaction().commit();
		session.close();

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
