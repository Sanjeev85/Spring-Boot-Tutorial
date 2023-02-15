package com.springrest.springrest.services;

import com.springrest.springrest.Dao.CourseDao;
import com.springrest.springrest.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CouseServiceImplementation implements CourseService {
    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long id) {
        return courseDao.getOne(id);
    }

    @Override
    public Course addCourse(Course c) {
        courseDao.save(c);
        return c;
    }

    @Override
    public Course updateCourse(Course c) {
        courseDao.save(c);
        return c;
    }

    @Override
    public Course deleteCourse(long id) {
        Course toDelete = courseDao.getOne(id);
        courseDao.delete(toDelete);
        return toDelete;
    }
}

/**
    List<Course> mCourses;

    public CouseServiceImplementation() {
        mCourses = new ArrayList<>();
        mCourses.add(new Course(145, "Java Course", "basic of java"));
        mCourses.add(new Course(146, "C++ Course", "basic of C++"));

    }

    @Override
    public List<Course> getCourses() {
        return this.mCourses;
    }

    @Override
    public Course getCourse(long id) {
        Course c = null;
        for (Course crs : mCourses) {
            if (crs.getId() == id) {
                c = crs;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourse(Course c) {
        this.mCourses.add(c);
        return c;
    }

    @Override
    public Course updateCourse(Course crs) {

        mCourses.forEach(currCourse -> {
            if (currCourse.getId() == crs.getId()) {
                currCourse.setTitle(crs.getTitle());
                currCourse.setDescription(crs.getDescription());
            }
        });

        for (int i = 0; i < mCourses.size(); i++) {
            if (crs.getId() == mCourses.get(i).getId()) {
                mCourses.set(i, crs);
                return mCourses.get(i);
            }
        }

        return crs;
    }

    @Override
    public Course deleteCourse(long id) {
        Course currCourse = null;
        for (int i = 0; i < mCourses.size(); i++) {
            currCourse = mCourses.get(i);
            if (currCourse.getId() == id) {
                mCourses.remove(currCourse);
                break;
            }
        }
        return currCourse;
    }
    **/

