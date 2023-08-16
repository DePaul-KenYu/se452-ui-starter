package edu.depaul.cdm.se452.concept.rdbm.school.complex.inheritance;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository<T extends Employee> extends CrudRepository<T, Long> {
    
}
