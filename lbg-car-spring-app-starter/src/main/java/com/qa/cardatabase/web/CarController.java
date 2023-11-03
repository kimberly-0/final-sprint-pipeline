package com.qa.cardatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.cardatabase.data.entity.Car;
import com.qa.cardatabase.data.repository.CarRepository;

@RestController
public class CarController {

	@Autowired
	private CarRepository repository;
	
//	public CarController() {
//		// TODO Auto-generated constructor stub
//	}
	
	@RequestMapping("/cars")
	public Iterable<Car> getCars() {
		return repository.findAll();
	}

}
