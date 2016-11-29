package com.sudhir.repository;

import com.sudhir.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;

/**
 * @author sudhir
 *         Date:9/11/16
 *         Time:7:54 AM
 *         Project:reservation-services
 */
@RepositoryRestResource
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    @RestResource(path = "by-name")
    public Collection<Reservation> findByReservationName(@Param("rm") String reservationName);
}
