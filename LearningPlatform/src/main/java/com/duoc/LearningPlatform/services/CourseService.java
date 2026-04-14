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

    //metodo para traer todos los cursos 
    public List<Course> getCourses() {
        return courseRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Course::getName))
                .toList();
    }

    //metodo para traer solo los cursos activos 
    public List <Course> getActiveCourses(){
        return courseRepository.findByActiveTrue()
                .stream()
                .sorted(Comparator.comparing (Course::getName))
                .toList();
    }

    // metodo para crear curso 
    public Course createCourse(Course course){
        return courseRepository.save(course); 
    }

    // metodo para actualizar curso
    public Course updateCourse(Long id, Course updatedCourse){
        Course existingCourse = courseRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Curso no encontrado"));  

        existingCourse.setName(updatedCourse.getName());
        existingCourse.setInstructor(updatedCourse.getInstructor());
        existingCourse.setActive(updatedCourse.isActive());

        return courseRepository.save(existingCourse); 
    }


    // metodo para eliminar curso 
    public void deleteCourse(Long id){
        Course targetCourse = courseRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        courseRepository.delete(targetCourse);
    }

    //metodo para cambiar solo el estado en vez de borrar el curso
    public Course deactivateCourse(Long id){
        Course targetCourse = courseRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Curso no encontrado")); 

         if (!targetCourse.isActive()) {
        throw new RuntimeException("El curso ya está inactivo");
         }

        targetCourse.setActive(false); 

        return courseRepository.save(targetCourse); 

    }

}

