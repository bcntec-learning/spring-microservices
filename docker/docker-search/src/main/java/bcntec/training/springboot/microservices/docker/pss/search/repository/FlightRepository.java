package bcntec.training.springboot.microservices.docker.pss.search.repository;


import bcntec.training.springboot.microservices.docker.pss.search.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByOriginAndDestinationAndFlightDate(String origin, String destination, String flightDate);

    Flight findByFlightNumberAndFlightDate(String flightNumber, String flightDate);
} 