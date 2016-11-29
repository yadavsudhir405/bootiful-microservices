package com.example.controller;

import com.example.model.Reservation;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author sudhir
 *         Date:27/11/16
 *         Time:8:14 PM
 *         Project:reservation-client
 */
@RestController
@RequestMapping("/reservations")
public class ReservationApiGatewayController {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallBackGetReservations")
    @RequestMapping(method = RequestMethod.GET,value = "/names")
    public Collection<String> getReservationNames(){

        ParameterizedTypeReference<Resources<Reservation>> ptr=new ParameterizedTypeReference<Resources<Reservation>>
                () {
        };

		ResponseEntity<Resources<Reservation>> entity= this.restTemplate.exchange
				("http://reservation-services/reservations",
				HttpMethod.GET, null,ptr);
       // System.out.println(entity.getBody().getContent().getReservationName());
        return entity.getBody()
                .getContent()
                .stream()
                .map(Reservation::getReservationName)
                .collect(Collectors.toList());


    }

    public Collection<String> fallBackGetReservations(){
        return new ArrayList<>();
    }
}
