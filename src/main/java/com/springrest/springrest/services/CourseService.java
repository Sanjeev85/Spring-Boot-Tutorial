package com.springrest.springrest.services;

import com.springrest.springrest.models.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getCourses();
    public Course getCourse(long id);
    public Course addCourse(Course c);
    public Course updateCourse(Course c);
    public Course deleteCourse(long id);
}
