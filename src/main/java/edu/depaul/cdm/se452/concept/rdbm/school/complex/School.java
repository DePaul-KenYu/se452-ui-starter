package edu.depaul.cdm.se452.concept.rdbm.school.complex;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToOne
    private Address address;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @ToString.Exclude
    private University university;   
}
