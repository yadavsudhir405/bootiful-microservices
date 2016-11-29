package com.sudhir.mesagechannels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author sudhir
 *         Date:29/11/16
 *         Time:1:21 PM
 *         Project:reservation-services
 */
public interface ReservationReceiver {
    String RESERVATION_CHANNEL="reservation_channel";

    @Input(ReservationReceiver.RESERVATION_CHANNEL)
    SubscribableChannel reservationChannel();
}
