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
public class RoasterDaoTest {

    @Autowired
    protected RoasterDao roasterDao;

    @Autowired
    CoffeeDao coffeeDao;

    @Before
    public void setUp() throws Exception {

        List<Coffee> coffeeList = coffeeDao.getAllCoffees();
        for(Coffee coffee: coffeeList){
            coffeeDao.deleteCoffee(coffee.getId());
        }

        List<Roaster> roasterList = roasterDao.getAllRoasters();
        roasterList.stream().forEach(Roaster -> roasterDao.deleteRoaster(Roaster.getId()));

    }

    @Test
    public void addGetDeleteRoaster() {

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

        Roaster roaster2 = roasterDao.getRoaster(roaster.getId());

        assertEquals(roaster2, roaster);

        roasterDao.deleteRoaster(roaster.getId());

        roaster2 = roasterDao.getRoaster(roaster.getId());

        assertNull(roaster2);
    }

    @Test
    public void getAllRoasters() {
        Roaster roaster = new Roaster();
        roaster.setName("Switch & Finch");
        roaster.setStreet("600 Broad St");
        roaster.setCity("Rome");
        roaster.setState("GA");
        roaster.setZipCode("30161");
        roaster.setPhone("7062376750");
        roaster.setEmail("jkldfs@live.com");
        roaster.setNote("iroirroir");
        roasterDao.addRoaster(roaster);

        Roaster roaster2 = new Roaster();
        roaster2.setName("Bobs");
        roaster2.setStreet("422 Broad St");
        roaster2.setCity("Rome");
        roaster2.setState("GA");
        roaster2.setZipCode("30161");
        roaster2.setPhone("7062228888");
        roaster2.setEmail("kiutt@live.com");
        roaster2.setNote("btrwvr");
        roasterDao.addRoaster(roaster2);

        List<Roaster> roasterList = roasterDao.getAllRoasters();

        assertEquals(roasterList.size(), 2);

    }

    @Test
    public void updateRoaster() {
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

        roaster.setName("Bobs");
        roaster.setStreet("422 Broad St");
        roaster.setCity("Rome");
        roaster.setState("GA");
        roaster.setZipCode("30161");
        roaster.setPhone("7062228888");
        roaster.setEmail("kiutt@live.com");
        roaster.setNote("btrwvr");

        roasterDao.updateRoaster(roaster);

        Roaster roaster1 = roasterDao.getRoaster(roaster.getId());

        assertEquals(roaster1, roaster);

    }


}