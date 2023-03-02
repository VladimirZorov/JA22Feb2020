package parking;

import java.util.ArrayList;
import java.util.Collection;

public class Parking {

    private String type;
    private int capacity;
    private Collection<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (data.size() < capacity) {
            data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        Car latestCar = null;
        int maxYear = 0;

        for (Car car : data) {
            if (car.getYear() > maxYear) {
                maxYear = car.getYear();
                latestCar = car;
                return  car;
            }
        }
        return null;
    }

    public Car getCar(String manufacturer, String model) {
        return data.stream().filter(car -> car.getManufacturer().equals(manufacturer))
                .filter(car -> car.getModel().equals(model))
                .findFirst().orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("The cars are parked in %s:", type)).append(System.lineSeparator());
        for (Car car : data) {
            sb.append(car.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
