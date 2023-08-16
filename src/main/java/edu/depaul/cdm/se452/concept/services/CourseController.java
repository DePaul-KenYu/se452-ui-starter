package edu.depaul.cdm.se452.concept.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.cdm.se452.concept.rdbm.school.simple.Course;
import edu.depaul.cdm.se452.concept.rdbm.school.simple.CourseRepository;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseRepository repo;

    @GetMapping("/")
    public List<Course> findAll() {
        List<Course> retval = StreamSupport.stream(repo.findAll().spliterator(), false).collect(Collectors.toList());
        return retval;
    }    

    @GetMapping(value="/{id}")
    public Course find(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody Course course) {
        Course saved = repo.save(course);
        return saved.getId();
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable( "id" ) Long id, @RequestBody Course course) {
        // Given it is an update, need to find the course
        Course foundCourse = repo.findById(id).orElse(new Course());

        // if foundCourse ID does not match the id then it means that we created new course object and so will need to
        // set the primary key
        if (foundCourse.getId() != id) {
            foundCourse.setId(id);
        }
        repo.save(foundCourse);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        repo.deleteById(id);
    }    

}
