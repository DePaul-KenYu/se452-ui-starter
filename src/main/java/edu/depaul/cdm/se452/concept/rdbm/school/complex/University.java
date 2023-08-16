package edu.depaul.cdm.se452.concept.rdbm.school.complex;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    
    @OneToMany
    private List<School> schools;    

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "university_instructor", 
      joinColumns = @JoinColumn(name = "university_id", referencedColumnName = "id"), 
      inverseJoinColumns = @JoinColumn(name = "instructor_id", 
      referencedColumnName = "id"))
    @ToString.Exclude
    private List<Instructor> instructors;    
}
