package edu.depaul.cdm.se452.concept.rdbm.school.simple;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;

/**
 * Minimialist code to map against database when then table/column is same as the class/property
 */
@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "course dept must be set")
    @Size(min= 2,max = 4, message = "dept must be between 2 and 4 characters")
    private String dept;

    @NotBlank
    @Size(min= 2,max = 7, message = "dept num must be between 2 and 6 characters")
    private String num;

    private String description;

}