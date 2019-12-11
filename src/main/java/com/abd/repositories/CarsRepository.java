package com.abd.repositories;

import java.util.List;

import org.hibernate.Query;
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

	public CarsEntity getById(Long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		CarsEntity ce = (CarsEntity) session.get(CarsEntity.class, id);

		session.getTransaction().commit();
		session.close();
		return ce;
	}

	public List<CarsEntity> getBymake(String make) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("select c from CarsEntity c where c.make =:make");
		query.setParameter("make", make);

		List<CarsEntity> cars = query.list();

		session.getTransaction().commit();
		session.close();
		return cars;
	}

	public void update(CarsEntity cars) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.merge(cars);
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
