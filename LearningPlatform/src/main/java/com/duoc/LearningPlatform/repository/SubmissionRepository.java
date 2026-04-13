package com.duoc.LearningPlatform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duoc.LearningPlatform.model.Submission;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
    List<Submission> findByCourseId(Long courseId);
    List<Submission> findByStudentId(Long studentId);
}
