import com.company.carinventoryjdbctemplatedao.model.Car;
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
public class CarLotDaoTest {

    @Autowired
    protected carInventoryDao dao;

    @Before
    public void setUp() throws Exception {

        List<Car> CarList = dao.getAllCar();
        CarList.stream().forEach(Car -> dao.deleteCar(Car.getId()));

    }

    @Test
    public void addGetDeleteCar() {
        Car car = new Car();
        car.setMake("Honda");
        car.setModel("Fjiemc");
        car.setYear("2019");
        car.setColor("Black");


        car = dao.addCar(car);

        Car car2 = dao.getCar(car.getId());

        assertEquals(car, car2);


        dao.deleteCar(car.getId());

        car2 = dao.getCar(car.getId());

        assertNull(car2);

    }

    @Test
    public void getAllCars(){
        Car car = new Car();
        car.setMake("Honda");
        car.setModel("Fjiemc");
        car.setYear("2019");
        car.setColor("Black");

        dao.addCar(car);

        car = new Car();
        car.setMake("Ford");
        car.setModel("Fikiu");
        car.setYear("2019");
        car.setColor("Black");

        dao.addCar(car);

        List<Car> carList = dao.getAllCar();

        assertEquals(2, carList.size());

    }

    @Test
    public void getCarButMake(){

        Car car = new Car();
        car.setMake("Honda");
        car.setModel("Fjiemc");
        car.setYear("2019");
        car.setColor("Black");

        dao.addCar(car);

        car = new Car();
        car.setMake("Ford");
        car.setModel("Fikiu");
        car.setYear("2019");
        car.setColor("Black");

        dao.addCar(car);

        List<Car> CarList = dao.getCarByMake("Ford");
        assertEquals(1, CarList.size());

    }

    @Test
    public void updateCar(){

        Car car = new Car();
        car.setMake("Honda");
        car.setModel("Fjiemc");
        car.setYear("2019");
        car.setColor("Black");

        car = dao.addCar(car);

        car.setMake("Ford");
        car.setModel("Fikiu");
        car.setYear("2019");
        car.setColor("Black");

        dao.updateCar(car);

        Car car2 = dao.getCar(car.getId());

        assertEquals(car, car2);
    }
}