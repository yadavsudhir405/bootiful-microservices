package com.sudhir.config;

import com.sudhir.entity.Person;
import com.sudhir.entity.Reservation;
import com.sudhir.repository.PersonRepository;
import com.sudhir.repository.ReservationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Stream;

/**
 * @author sudhir
 *         Date:9/11/16
 *         Time:8:01 AM
 *         Project:reservation-services
 */
@Configuration
public class Appconfig {
    @Bean
    CommandLineRunner commandLineRunner(ReservationRepository reservationRepository){
        return strings -> {
            Stream.of("Bangalore","Delhi","Pune","Kolkata").forEach(city->reservationRepository.save(new Reservation
                    (city)));
        };
    }

    @Bean
    CommandLineRunner commandLineRunner1(PersonRepository personRepository){
        return strings -> {
            Stream.of("Sudhir","Joe","john","Eric").forEach(city->personRepository.save(new Person(city,"Bangalore")
            ));
        };
    }

}
