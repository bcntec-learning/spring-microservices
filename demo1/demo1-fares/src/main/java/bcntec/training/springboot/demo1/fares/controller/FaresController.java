package bcntec.training.springboot.demo1.fares.controller;

import bcntec.training.springboot.demo1.fares.component.FaresComponent;
import bcntec.training.springboot.demo1.fares.entity.Fare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/fares")
public class FaresController {
    FaresComponent faresComponent;

    @Autowired
    FaresController(FaresComponent faresComponent) {
        this.faresComponent = faresComponent;
    }

    @RequestMapping("/get")
    Fare getFare(@RequestParam(value = "flightNumber") String flightNumber, @RequestParam(value = "flightDate") String flightDate) {
        return faresComponent.getFare(flightNumber, flightDate);
    }
}
