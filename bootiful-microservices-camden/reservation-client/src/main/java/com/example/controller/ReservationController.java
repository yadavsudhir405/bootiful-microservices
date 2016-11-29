package com.example.controller;

import com.example.messageChannel.ProducerChannel;
import com.example.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import org.springframework.messaging.Message;
//import org.springframework.messaging.support.MessageBuilder;

/**
 * @author sudhir
 *         Date:28/11/16
 *         Time:5:04 PM
 *         Project:reservation-client
 */
@RestController
public class ReservationController {

    @Autowired
    private ProducerChannel producer;
    @PostMapping(path = "/reservationSave")
    public void sendReservationDetail(@RequestBody Reservation reservation){
        System.out.println("request received");
        /*Reservation reservation=new Reservation();
        reservation.setReservationName("Chennai");*/
        Message<Reservation> message= MessageBuilder.withPayload(reservation).build();
        producer.output().send(message);
        System.out.println("Message Sent to RabbitMq");
    }
}
