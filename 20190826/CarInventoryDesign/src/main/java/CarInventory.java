import java.util.ArrayList;
import java.util.List;

public class CarInventory {
    private List<Car> carList;

    public List<Car> getCarList() {
        if(carList == null)
            carList = new ArrayList<>();
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public void addCar(Car car) {
        getCarList().add(car);
    }

    public CarInventory(List<Car> carList) {
        this.carList = carList;
    }
}
