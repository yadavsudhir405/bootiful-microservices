package com.sudhir.repository;

import com.sudhir.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;

/**
 * @author sudhir
 *         Date:9/11/16
 *         Time:7:56 AM
 *         Project:reservation-services
 */
@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Person,Long> {
    @RestResource(path = "by-address")
    public Collection<Person> findByAddress(@Param("address") String address);
}
