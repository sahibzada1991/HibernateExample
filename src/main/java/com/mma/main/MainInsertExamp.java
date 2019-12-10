package com.mma.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.abd.repositories.CarsRepository;
import com.ssd.entities.CarsEntity;

public class MainInsertExamp {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("Application-context.xml");
		CarsRepository carsrepository = (CarsRepository) ctx.getBean("cars");

		CarsEntity ce = new CarsEntity();

		ce.setVinNumber("vbn6765434");
		ce.setMake("Jeep");
		ce.setModel("SRT");
		ce.setYear(2019);

		carsrepository.save(ce);

	}

}
