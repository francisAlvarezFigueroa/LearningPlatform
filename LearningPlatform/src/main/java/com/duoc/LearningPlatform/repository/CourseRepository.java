package com.duoc.LearningPlatform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duoc.LearningPlatform.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByActiveTrue();
}
