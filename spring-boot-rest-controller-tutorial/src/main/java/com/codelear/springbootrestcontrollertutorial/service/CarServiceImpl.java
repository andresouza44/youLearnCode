package com.codelear.springbootrestcontrollertutorial.service;

import com.codelear.springbootrestcontrollertutorial.model.Car;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class CarServiceImpl implements CarService{

    List <Car> cars = new ArrayList<>(Arrays.asList(
                    new Car(1L,"Astra", "Opel", 100, 18000d),
                    new Car(2L, "Insignia", "Opel", 120, 22000d),
                    new Car(3L, "Golf", "VW", 90, 17000d))
                    );


    @Override
    public List<Car> getAllCars() {
        return cars;
    }

    @Override
    public List<Car> getCarsWithPriceFilter(Double min, Double max) {
        return   cars.stream()
                .filter(c -> c.getPrice()>= min && c.getPrice() <= max)
                .toList();

    }

    @Override
    public Car getById(Long id) {

        return cars.stream()
                .filter(c -> c.getId().equals(id))
                .findAny()
                .orElseThrow();
    }

    @Override
    public Car update(Long id, Car carRequest) {
       Car carUpdate = this.getById(id);
        carUpdate.setModel(carRequest.getModel());
        carUpdate.setBrand(carRequest.getBrand());
        carUpdate.setHorses(carRequest.getHorses());
        carUpdate.setPrice(carRequest.getPrice());

        return carUpdate;
    }

    @Override
    public Car create(Car car) {
        Long newId = cars.stream()
                .mapToLong( c -> c.getId())
                .max()
                .orElse(0L) + 1L;
        car.setId(newId);
        cars.add(car);
        return getById(car.getId());
    }

    @Override
    @Positive
    public void delete(Long id) {
        boolean successfulDeletation = cars.removeIf(car -> car.getId().equals(id));
        if (!successfulDeletation){
            throw new NoSuchElementException();
        }



    }
}
