package com.sudhir.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author sudhir
 *         Date:9/11/16
 *         Time:7:54 AM
 *         Project:reservation-services
 */

@Entity
public class Reservation{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String reservationName;
    public Reservation(){

    }
    public Reservation(String reservationName) {
        this.reservationName = reservationName;
    }

    public Long getId() {
        return id;
    }

    public String getReservationName() {
        return reservationName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return reservationName != null ? reservationName.equals(that.reservationName) : that.reservationName == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (reservationName != null ? reservationName.hashCode() : 0);
        return result;
    }
}
