package edu.depaul.cdm.se452.concept.rdbm.school.complex.inheritance;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Employee {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private LocalDate startDate;
    
}
