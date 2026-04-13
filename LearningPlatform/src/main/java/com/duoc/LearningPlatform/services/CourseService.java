package com.duoc.LearningPlatform.services;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.duoc.LearningPlatform.model.Course;
import com.duoc.LearningPlatform.repository.CourseRepository;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourses() {
        return courseRepository.findAll()
                .stream()
                .filter(Course::isActive)
                .sorted(Comparator.comparing(Course::getName))
                .toList();
    }
}
