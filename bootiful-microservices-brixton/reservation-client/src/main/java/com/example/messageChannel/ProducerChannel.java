package com.example.messageChannel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author sudhir
 *         Date:28/11/16
 *         Time:4:58 PM
 *         Project:reservation-client
 */
public interface ProducerChannel {
    String RESERVATION_CHANNEL="reservationChannel";
    @Output(ProducerChannel.RESERVATION_CHANNEL)
    MessageChannel output();
}
