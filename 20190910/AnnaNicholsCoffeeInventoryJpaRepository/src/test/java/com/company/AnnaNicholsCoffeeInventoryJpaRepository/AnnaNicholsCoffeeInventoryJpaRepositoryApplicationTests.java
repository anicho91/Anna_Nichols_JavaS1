package com.company.AnnaNicholsCoffeeInventoryJpaRepository;

import com.company.AnnaNicholsCoffeeInventoryJpaRepository.dao.CoffeeRepository;
import com.company.AnnaNicholsCoffeeInventoryJpaRepository.dao.RoasterRepository;
import com.company.AnnaNicholsCoffeeInventoryJpaRepository.dto.Coffee;
import com.company.AnnaNicholsCoffeeInventoryJpaRepository.dto.Roaster;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnnaNicholsCoffeeInventoryJpaRepositoryApplicationTests {

	@Autowired
	CoffeeRepository coffeeRepo;
	@Autowired
	RoasterRepository roasterRepo;

	@Ignore
	@Test
	public void contextLoads() {
	}

	@Test
	public void createTest(){
		coffeeRepo.deleteAll();
		roasterRepo.deleteAll();

		Roaster roaster = new Roaster();
		roaster.setName("Switch & Finch");
		roaster.setStreet("600 Broad St");
		roaster.setCity("Rome");
		roaster.setState("GA");
		roaster.setZipCode("30161");
		roaster.setPhone("7062376750");
		roaster.setEmail("jkldfs@live.com");
		roaster.setNote("iroirroir");
		roasterRepo.save(roaster);


		Coffee coffee = new Coffee();
		coffee.setRoasterId(roaster.getId());
		coffee.setName("Lington");
		coffee.setCount(34);
		coffee.setUnitPrice(10.00);
		coffee.setDescription("Descriptionsfdjklla");
		coffee.setType("Sumatra");
		coffeeRepo.save(coffee);

		List<Coffee> coffeeList = coffeeRepo.findAll();
		assertEquals(1, coffeeList.size());

	}

	@Test
	public void readTest(){

		Coffee coffee = new Coffee();
		coffee.setName("Lington");
		coffee.setCount(34);
		coffee.setUnitPrice(10.00);
		coffee.setDescription("Descriptions");
		coffee.setType("Sumatra");
		Set<Coffee> coffeeSet = new HashSet<>();
		coffeeSet.add(coffee);


		Roaster roaster = new Roaster();
		roaster.setName("Switch & Finch");
		roaster.setStreet("600 Broad St");
		roaster.setCity("Rome");
		roaster.setState("GA");
		roaster.setZipCode("30161");
		roaster.setPhone("7062376750");
		roaster.setEmail("jkldfs@live.com");
		roaster.setNote("iroirroir");
		roasterRepo.save(roaster);
		coffee.setRoasterId(roaster.getId());

		coffeeRepo.save(coffee);

		List<Coffee> coffees = coffeeRepo.findById(1);

		assertEquals(1, coffees.size());

		List<Roaster> roasters = roasterRepo.findById(1);

		assertEquals(1, roasters.size());
	}

	@Test
	public void updateTest(){
		coffeeRepo.deleteAll();
		roasterRepo.deleteAll();

		Coffee coffee = new Coffee();
		coffee.setName("Lington");
		coffee.setCount(34);
		coffee.setUnitPrice(10.00);
		coffee.setDescription("Descriptions");
		coffee.setType("Sumatra");
		Set<Coffee> coffeeSet = new HashSet<>();
		coffeeSet.add(coffee);

		Roaster roaster = new Roaster();
		roaster.setName("Switch & Finch");
		roaster.setStreet("600 Broad St");
		roaster.setCity("Rome");
		roaster.setState("GA");
		roaster.setZipCode("30161");
		roaster.setPhone("7062376750");
		roaster.setEmail("jkldfs@live.com");
		roaster.setNote("iroirroir");
		roasterRepo.save(roaster);
		coffee.setRoasterId(roaster.getId());

		coffeeRepo.save(coffee);

		Integer roasterId = roaster.getId();
		Roaster roaster1 = roasterRepo.findById(roasterId).get(0);
		roaster1.setCity("Berlin");
		roasterRepo.save(roaster1);

		List<Roaster> roasters = roasterRepo.findAll();
		assertEquals("Berlin", roasters.get(0).getCity());

		Integer coffeeId = coffee.getId();
		Coffee coffee1 = coffeeRepo.findById(coffeeId).get(0);
		coffee1.setName("Toffee");
		coffeeRepo.save(coffee1);

		List<Coffee> coffees = coffeeRepo.findAll();
		assertEquals("Toffee", coffees.get(0).getName());
	}

	@Test
	public void coffeeByType(){
		coffeeRepo.deleteAll();
		roasterRepo.deleteAll();

		Coffee coffee = new Coffee();
		coffee.setName("Lington");
		coffee.setCount(34);
		coffee.setUnitPrice(10.00);
		coffee.setDescription("Descriptions");
		coffee.setType("Sumatra");
		Set<Coffee> coffeeSet = new HashSet<>();
		coffeeSet.add(coffee);

		Coffee coffee2 = new Coffee();
		coffee2.setName("Starbucks");
		coffee2.setCount(15);
		coffee2.setUnitPrice(20.00);
		coffee2.setDescription("Descriptions");
		coffee2.setType("Columbian");
		coffeeSet.add(coffee2);

		Roaster roaster = new Roaster();
		roaster.setName("Switch & Finch");
		roaster.setStreet("600 Broad St");
		roaster.setCity("Rome");
		roaster.setState("GA");
		roaster.setZipCode("30161");
		roaster.setPhone("7062376750");
		roaster.setEmail("jkldfs@live.com");
		roaster.setNote("iroirroir");
		roasterRepo.save(roaster);
		coffee.setRoasterId(roaster.getId());
		coffee2.setRoasterId(roaster.getId());

		coffeeRepo.save(coffee);
		coffeeRepo.save(coffee2);

		List<Coffee> coffees = coffeeRepo.findByType("Columbian");

		assertEquals("Columbian", coffees.get(0).getType());
	}

	@Test
	public void findByRoaster(){
		coffeeRepo.deleteAll();
		roasterRepo.deleteAll();

		Coffee coffee = new Coffee();
		coffee.setName("Lington");
		coffee.setCount(34);
		coffee.setUnitPrice(10.00);
		coffee.setDescription("Descriptions");
		coffee.setType("Sumatra");
		Set<Coffee> coffeeSet = new HashSet<>();
		coffeeSet.add(coffee);

		Coffee coffee2 = new Coffee();
		coffee2.setName("Starbucks");
		coffee2.setCount(15);
		coffee2.setUnitPrice(20.00);
		coffee2.setDescription("Descriptions");
		coffee2.setType("Columbian");
		coffeeSet.add(coffee2);

		Roaster roaster = new Roaster();
		roaster.setName("Switch & Finch");
		roaster.setStreet("600 Broad St");
		roaster.setCity("Rome");
		roaster.setState("GA");
		roaster.setZipCode("30161");
		roaster.setPhone("7062376750");
		roaster.setEmail("jkldfs@live.com");
		roaster.setNote("iroirroir");
		roasterRepo.save(roaster);
		coffee.setRoasterId(roaster.getId());

		coffeeRepo.save(coffee);

		Roaster roaster2 = new Roaster();
		roaster2.setName("Bobs");
		roaster2.setStreet("422 Broad St");
		roaster2.setCity("Rome");
		roaster2.setState("GA");
		roaster2.setZipCode("30161");
		roaster2.setPhone("7062228888");
		roaster2.setEmail("kiutt@live.com");
		roaster2.setNote("btrwvr");
		roasterRepo.save(roaster2);
		coffee2.setRoasterId(roaster2.getId());

		coffeeRepo.save(coffee2);

		List<Coffee> coffees = coffeeRepo.findByRoasterId(roaster2.getId());

		assertEquals("Starbucks", coffees.get(0).getName());
	}

	@Test
	public void findByRoasterAndType(){
		coffeeRepo.deleteAll();
		roasterRepo.deleteAll();

		Coffee coffee = new Coffee();
		coffee.setName("Lington");
		coffee.setCount(34);
		coffee.setUnitPrice(10.00);
		coffee.setDescription("Descriptions");
		coffee.setType("Sumatra");
		Set<Coffee> coffeeSet = new HashSet<>();
		coffeeSet.add(coffee);

		Coffee coffee2 = new Coffee();
		coffee2.setName("Starbucks");
		coffee2.setCount(15);
		coffee2.setUnitPrice(20.00);
		coffee2.setDescription("Descriptions");
		coffee2.setType("Columbian");
		coffeeSet.add(coffee2);

		Roaster roaster = new Roaster();
		roaster.setName("Switch & Finch");
		roaster.setStreet("600 Broad St");
		roaster.setCity("Rome");
		roaster.setState("GA");
		roaster.setZipCode("30161");
		roaster.setPhone("7062376750");
		roaster.setEmail("jkldfs@live.com");
		roaster.setNote("iroirroir");
		roasterRepo.save(roaster);
		coffee.setRoasterId(roaster.getId());

		coffeeRepo.save(coffee);

		Roaster roaster2 = new Roaster();
		roaster2.setName("Bobs");
		roaster2.setStreet("422 Broad St");
		roaster2.setCity("Rome");
		roaster2.setState("GA");
		roaster2.setZipCode("30161");
		roaster2.setPhone("7062228888");
		roaster2.setEmail("kiutt@live.com");
		roaster2.setNote("btrwvr");
		roasterRepo.save(roaster2);
		coffee.setRoasterId(roaster2.getId());
		coffee2.setRoasterId(roaster2.getId());

		coffeeRepo.save(coffee);
		coffeeRepo.save(coffee2);

		List<Coffee> coffees = coffeeRepo.findByRoasterIdAndType(roaster2.getId(), "Sumatra");

		assertEquals("Sumatra", coffees.get(0).getType());
	}

}
