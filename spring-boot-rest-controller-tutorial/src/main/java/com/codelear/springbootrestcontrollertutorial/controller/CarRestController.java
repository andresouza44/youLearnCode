package com.codelear.springbootrestcontrollertutorial.controller;


import com.codelear.springbootrestcontrollertutorial.model.Car;
import com.codelear.springbootrestcontrollertutorial.service.CarService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/cars")
public class CarRestController {

    @Autowired
    CarService carService;

    @GetMapping
    public ResponseEntity <List<Car>> getAllCars(){
        List <Car> carsList = carService.getAllCars();
        return ResponseEntity.ok().body(carsList);
    }

    @GetMapping(value= "/{id}")
    public ResponseEntity <Car> getById(@PathVariable Long id){
       Car car = carService.getById(id);
       return ResponseEntity.ok().body(car);

    }
    @GetMapping(params = {"minPrice", "maxPrice"})
    public List<Car> getAllFilteredByPrice(
            @RequestParam (required = false) @Positive(message = "minPrice parameter must be greater than zero") Double minPrice,
            @RequestParam (required = false) @Positive(message = "maxPrice parameter must be greater than zero") Double maxPrice
    ){
        return carService.getCarsWithPriceFilter(minPrice, maxPrice);
    }

    @PostMapping
    public ResponseEntity<Car> saveNewCar(@RequestBody Car obj){
        carService.create(obj);
        return ResponseEntity.ok().body(obj);


    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Car> update( @PathVariable @Positive(message = "id must be a positive number")  Long id,@RequestBody  Car obj){
        carService.update(id, obj);
        return ResponseEntity.ok().body(obj);

    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity <Void> delete (@PathVariable @Positive(message = "id must be a positive number")  Long id){
        carService.delete(id);
        return  ResponseEntity.ok().build();
    }

}
