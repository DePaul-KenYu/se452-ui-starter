package edu.depaul.cdm.se452.concept.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.cdm.se452.concept.rdbm.school.simple.Student;
import edu.depaul.cdm.se452.concept.rdbm.school.simple.StudentRepository;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/students/")
@Log4j2
public class StudentService {
    @Autowired
    private StudentRepository repo;

    @GetMapping
    public List<Student> list() {
        log.traceEntry("Enter list");

        var retval = StreamSupport.stream(repo.findAll().spliterator(), false).collect(Collectors.toList());

        log.traceExit("Exit list", retval);
        return retval;
    }

    @PostMapping
    public Student save(@RequestBody Student student) {
        log.traceEntry("enter save", student);
        repo.save(student);
        log.traceExit("exit save", student);
        return student;
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id ) {
        log.traceEntry("Enter delete", id);
        repo.deleteById(id);
        log.traceExit("Exit delete");
    }           
}
