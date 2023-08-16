package edu.depaul.cdm.se452.concept.rdbm.school.complex;

import org.springframework.data.repository.CrudRepository;

public interface SchoolRepository extends CrudRepository<School, Long> { 
    public School findByName(String name);
}