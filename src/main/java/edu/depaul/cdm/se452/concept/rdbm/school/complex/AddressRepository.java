package edu.depaul.cdm.se452.concept.rdbm.school.complex;

import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
    Address findByLocation(String location);
}