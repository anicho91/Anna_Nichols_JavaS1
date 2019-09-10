package com.company.AnnaNicholsCarLotJpaRepository;

import com.company.AnnaNicholsCarLotJpaRepository.dao.CarRepository;
import com.company.AnnaNicholsCarLotJpaRepository.dto.Car;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnnaNicholsCarLotJpaRepositoryApplicationTests {

	@Autowired
	CarRepository carRepo;

	@Ignore
	@Test
	public void contextLoads() {
	}

	@Test
	public void createTest(){
		carRepo.deleteAll();

		Car car = new Car();
		car.setMake("Toyota");
		car.setModel("Camry");
		car.setYear("2012");
		car.setColor("Red");
		carRepo.save(car);

		List<Car> cars = carRepo.findAll();
		assertEquals(1, cars.size());
	}

	@Test
	public void readTest(){
		Car car = new Car();
		car.setMake("Toyota");
		car.setModel("Camry");
		car.setYear("2012");
		car.setColor("Red");
		carRepo.save(car);

		car = new Car();
		car.setMake("Jeep");
		car.setModel("Wrangler");
		car.setYear("2014");
		car.setColor("Black");
		carRepo.save(car);

		List<Car> cars1 = carRepo.findById(2);

		assertEquals(1, cars1.size());
	}

	@Test
	public void updateTest(){
		carRepo.deleteAll();

		Car car = new Car();
		car.setMake("Toyota");
		car.setModel("Camry");
		car.setYear("2012");
		car.setColor("Red");
		carRepo.save(car);


		Integer carId = car.getId();
		Car car1 = carRepo.findById(carId).get(0);
		car1.setColor("Pink");
		carRepo.save(car1);

		List<Car> cars = carRepo.findAll();
		assertEquals("Pink", cars.get(0).getColor());

	}

	@Test
	public void findMake(){
		carRepo.deleteAll();

		Car car = new Car();
		car.setMake("Toyota");
		car.setModel("Camry");
		car.setYear("2012");
		car.setColor("Red");
		carRepo.save(car);

		car = new Car();
		car.setMake("Jeep");
		car.setModel("Wrangler");
		car.setYear("2014");
		car.setColor("Black");
		carRepo.save(car);

		List<Car> cars = carRepo.findByMake("Jeep");

		assertEquals(1, cars.size());
	}

	@Test
	public void findColor(){
		carRepo.deleteAll();

		Car car = new Car();
		car.setMake("Toyota");
		car.setModel("Camry");
		car.setYear("2012");
		car.setColor("Red");
		carRepo.save(car);

		car = new Car();
		car.setMake("Jeep");
		car.setModel("Wrangler");
		car.setYear("2014");
		car.setColor("Black");
		carRepo.save(car);

		List<Car> cars = carRepo.findByColor("Red");

		assertEquals(1, cars.size());
	}

	@Test
	public void findMakeColor(){
		carRepo.deleteAll();

		Car car = new Car();
		car.setMake("Toyota");
		car.setModel("Camry");
		car.setYear("2012");
		car.setColor("Red");
		carRepo.save(car);

		car = new Car();
		car.setMake("Toyota");
		car.setModel("Camry");
		car.setYear("2016");
		car.setColor("Red");
		carRepo.save(car);

		car = new Car();
		car.setMake("Jeep");
		car.setModel("Wrangler");
		car.setYear("2014");
		car.setColor("Black");
		carRepo.save(car);

		List<Car> cars = carRepo.findByMakeAndColor("Toyota", "Red");

		assertEquals(2, cars.size());
	}

}
