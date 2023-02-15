package com.springrest.springrest.Dao;

import com.springrest.springrest.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Long> {

}
