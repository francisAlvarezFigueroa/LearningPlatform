package com.duoc.LearningPlatform.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.duoc.LearningPlatform.model.Course;
import com.duoc.LearningPlatform.services.CourseService;

@RestController
@RequestMapping("/courses")

public class CourseController {

    private final CourseService courseService; // instancia de course service para injeccion

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping // get list of available courses
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    @GetMapping("active") // get active courses
    public List<Course> getActiveCourses() {
        return courseService.getActiveCourses();
    }

    @PostMapping("create") // post course
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course newCourse = courseService.createCourse(course);
        return ResponseEntity.status(201).body(newCourse);
    }

}
