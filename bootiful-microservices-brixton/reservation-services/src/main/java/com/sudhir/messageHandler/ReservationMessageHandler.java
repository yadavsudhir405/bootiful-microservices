package com.sudhir.messageHandler;

import com.example.model.Reservation;
import com.sudhir.mesagechannels.ReservationReceiver;
import com.sudhir.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @author sudhir
 *         Date:29/11/16
 *         Time:1:25 PM
 *         Project:reservation-services
 */
@Component
public class ReservationMessageHandler {

    @Autowired
    private ReservationRepository reservationRepository;
    @StreamListener(ReservationReceiver.RESERVATION_CHANNEL)
    public void handleMessage(Reservation reservation){
        System.out.println("Message Received from RabbitMQ");
        com.sudhir.entity.Reservation reservation1=new com.sudhir.entity.Reservation(reservation.getReservationName());
        reservationRepository.save(reservation1);

    }
}
