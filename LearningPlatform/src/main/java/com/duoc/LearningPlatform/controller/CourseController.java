package com.duoc.LearningPlatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.LearningPlatform.model.Course;
import com.duoc.LearningPlatform.services.CourseService;

@RestController 
@RequestMapping("/api/courses")

public class CourseController {
    
    private final CourseService courseService;  // instancia de course service para injeccion

    public CourseController(CourseService courseService){
        this.courseService = courseService; 
    }

    @GetMapping  // get list of available courses 
    public List <Course> getCourses(){
        return courseService.getCourses(); 
    }
    


}
