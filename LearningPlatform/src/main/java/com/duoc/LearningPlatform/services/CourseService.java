package com.duoc.LearningPlatform.services;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Service;
import com.duoc.LearningPlatform.model.Course;

@Service
public class CourseService {

    
    private final CourseRepository courseRepository;  //instancia 

    private List<Course> courses = new ArrayList<>(); 

    public CourseService (CourseRepository courseRepository){ //TODO: implementar clase CourseRepository
        this.courseRepository = courseRepository; 
    }

    public List<Course> getCourses(){ // metodo que devuelve lista de cursos disponibles
        //todo: definir si queremos filtrar aqui o en el coursRepository con findByIsActiveTrue()
        return courseRepository.findAll()
        .stream()
        .filter(Course::isActive)
        .sorted(Comparator.comparing(Course::getName))
        .toList();
    }

}
