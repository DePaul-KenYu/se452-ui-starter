package edu.depaul.cdm.se452.concept.rdbm.school.complex;

import org.springframework.data.repository.CrudRepository;

public interface InstructorRepository extends CrudRepository<Instructor, Long> { 
    public Instructor findByName(String name);
}
