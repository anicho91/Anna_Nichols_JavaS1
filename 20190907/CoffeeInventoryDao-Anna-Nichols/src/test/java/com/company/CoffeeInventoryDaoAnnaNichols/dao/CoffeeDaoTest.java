package com.company.CoffeeInventoryDaoAnnaNichols.dao;

import com.company.CoffeeInventoryDaoAnnaNichols.model.Coffee;
import com.company.CoffeeInventoryDaoAnnaNichols.model.Roaster;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CoffeeDaoTest {

    @Autowired
    RoasterDao roasterDao;

    @Autowired
    CoffeeDao coffeeDao;

    @Before
    public void setUp() throws Exception {

        List<Coffee> coffeeList = coffeeDao.getAllCoffees();
        for(Coffee coffee: coffeeList){
            coffeeDao.deleteCoffee(coffee.getId());
        }

        List<Roaster> roasterList = roasterDao.getAllRoasters();
        for ( Roaster roaster : roasterList){
            roasterDao.deleteRoaster(roaster.getId());
        }

    }

    @Test
    public void addGetDeleteCoffee() {

        Roaster roaster = new Roaster();
        roaster.setName("Switch & Finch");
        roaster.setStreet("600 Broad St");
        roaster.setCity("Rome");
        roaster.setState("GA");
        roaster.setZipCode("30161");
        roaster.setPhone("7062376750");
        roaster.setEmail("jkldfs@live.com");
        roaster.setNote("iroirroir");
        roaster = roasterDao.addRoaster(roaster);

        Coffee coffee = new Coffee();
        coffee.setRoasterId(roaster.getId());
        coffee.setName("Lington");
        coffee.setCount(34);
        coffee.setUnitPrice(10.00);
        coffee.setDescription("Descriptionsfdjklla");
        coffee.setType("Sumatra");
        coffee = coffeeDao.addCoffee(coffee);

        Coffee coffee2 = coffeeDao.getCoffee(coffee.getId());

        assertEquals(coffee2, coffee);

        coffeeDao.deleteCoffee(coffee.getId());

        coffee2 = coffeeDao.getCoffee(coffee.getId());

        assertNull(coffee2);
    }

    @Test
    public void getCoffeeByRoaster() {

        Roaster roaster = new Roaster();
        roaster.setName("Switch & Finch");
        roaster.setStreet("600 Broad St");
        roaster.setCity("Rome");
        roaster.setState("GA");
        roaster.setZipCode("30161");
        roaster.setPhone("7062376750");
        roaster.setEmail("jkldfs@live.com");
        roaster.setNote("iroirroir");
        roaster = roasterDao.addRoaster(roaster);

        Roaster roaster2 = new Roaster();
        roaster2.setName("Bobs");
        roaster2.setStreet("422 Broad St");
        roaster2.setCity("Rome");
        roaster2.setState("GA");
        roaster2.setZipCode("30161");
        roaster2.setPhone("7062228888");
        roaster2.setEmail("kiutt@live.com");
        roaster2.setNote("btrwvr");
        roaster2 = roasterDao.addRoaster(roaster2);

        Coffee coffee = new Coffee();
        coffee.setRoasterId(roaster.getId());
        coffee.setName("Lington");
        coffee.setCount(34);
        coffee.setUnitPrice(10.00);
        coffee.setDescription("Descriptionsfdjklla");
        coffee.setType("Sumatra");
        coffee = coffeeDao.addCoffee(coffee);

        coffee = new Coffee();
        coffee.setRoasterId(roaster2.getId());
        coffee.setName("Mandheling");
        coffee.setCount(20);
        coffee.setUnitPrice(15.00);
        coffee.setDescription("Descriptionsfdjklla");
        coffee.setType("Sumatra");
        coffee = coffeeDao.addCoffee(coffee);

        List<Coffee> coffeeList = coffeeDao.getCoffeeByRoaster(roaster.getId());
        assertEquals(coffeeList.size(), 1);

        coffeeList = coffeeDao.getCoffeeByRoaster(roaster2.getId());
        assertEquals(coffeeList.size(), 1);

    }

    @Test
    public void getCoffeeByType() {

        Roaster roaster = new Roaster();
        roaster.setName("Switch & Finch");
        roaster.setStreet("600 Broad St");
        roaster.setCity("Rome");
        roaster.setState("GA");
        roaster.setZipCode("30161");
        roaster.setPhone("7062376750");
        roaster.setEmail("jkldfs@live.com");
        roaster.setNote("iroirroir");
        roaster = roasterDao.addRoaster(roaster);

        Coffee coffee = new Coffee();
        coffee.setRoasterId(roaster.getId());
        coffee.setName("Lington");
        coffee.setCount(34);
        coffee.setUnitPrice(10.00);
        coffee.setDescription("Descriptionsfdjklla");
        coffee.setType("Sumatra");
        coffee = coffeeDao.addCoffee(coffee);

        Coffee coffee2 = new Coffee();
        coffee2.setRoasterId(roaster.getId());
        coffee2.setName("Mandheling");
        coffee2.setCount(20);
        coffee2.setUnitPrice(15.00);
        coffee2.setDescription("Descriptionsfdjklla");
        coffee2.setType("Guatemalan");
        coffee2 = coffeeDao.addCoffee(coffee2);

        List<Coffee> coffeeList = coffeeDao.getCoffeeByType(coffee.getType());
        assertEquals(coffee.getType(), "Sumatra");

        coffeeList = coffeeDao.getCoffeeByType(coffee2.getType());
        assertEquals(coffee2.getType(), "Guatemalan");
    }

    @Test
    public void getAllCoffees() {
        Roaster roaster = new Roaster();
        roaster.setName("Switch & Finch");
        roaster.setStreet("600 Broad St");
        roaster.setCity("Rome");
        roaster.setState("GA");
        roaster.setZipCode("30161");
        roaster.setPhone("7062376750");
        roaster.setEmail("jkldfs@live.com");
        roaster.setNote("iroirroir");
        roaster = roasterDao.addRoaster(roaster);

        Coffee coffee = new Coffee();
        coffee.setRoasterId(roaster.getId());
        coffee.setName("Lington");
        coffee.setCount(34);
        coffee.setUnitPrice(10.00);
        coffee.setDescription("Descriptionsfdjklla");
        coffee.setType("Sumatra");
        coffee = coffeeDao.addCoffee(coffee);

        Coffee coffee2 = new Coffee();
        coffee2.setRoasterId(roaster.getId());
        coffee2.setName("Mandheling");
        coffee2.setCount(20);
        coffee2.setUnitPrice(15.00);
        coffee2.setDescription("Descriptionsfdjklla");
        coffee2.setType("Guatemalan");
        coffee2 = coffeeDao.addCoffee(coffee2);

        List<Coffee> coffeeList = coffeeDao.getAllCoffees();

        assertEquals(coffeeList.size(), 2);

    }

    @Test
    public void updateCoffee() {

        Roaster roaster = new Roaster();
        roaster.setName("Switch & Finch");
        roaster.setStreet("600 Broad St");
        roaster.setCity("Rome");
        roaster.setState("GA");
        roaster.setZipCode("30161");
        roaster.setPhone("7062376750");
        roaster.setEmail("jkldfs@live.com");
        roaster.setNote("iroirroir");
        roaster = roasterDao.addRoaster(roaster);

        Coffee coffee = new Coffee();
        coffee.setRoasterId(roaster.getId());
        coffee.setName("Lington");
        coffee.setCount(34);
        coffee.setUnitPrice(10.00);
        coffee.setDescription("Descriptionsfdjklla");
        coffee.setType("Sumatra");
        coffee = coffeeDao.addCoffee(coffee);

        coffee.setName("Mandheling");
        coffee.setCount(20);
        coffee.setUnitPrice(15.00);
        coffee.setDescription("Descriptionsfdjklla");
        coffee.setType("Guatemalan");

        coffeeDao.updateCoffee(coffee);

        Coffee coffee2 = coffeeDao.getCoffee(coffee.getId());

        assertEquals(coffee2, coffee);

    }

}