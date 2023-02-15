package com.springrest.springrest.controller;

import com.springrest.springrest.models.Course;
import com.springrest.springrest.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private CourseService mService;
    @GetMapping("/")
    public String home() {
        return "from home";
    }
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return this.mService.getCourses();
    }
//    @GetMapping("/courses/{id}")
    @RequestMapping(path = "/courses/{id}", method = RequestMethod.GET)
    public Course geCourse(@PathVariable String id) {
        return this.mService.getCourse(Long.parseLong(id));
    }
    @PostMapping(path = "/courses", consumes = "application/json")
    public Course addCourse(@RequestBody Course course) {
        return this.mService.addCourse(course);
    }
    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course) {
        return this.mService.updateCourse(course);
    }
    @RequestMapping(path = "/deleteCourse/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String id) {
        try {
            this.mService.deleteCourse(Long.parseLong(id));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
