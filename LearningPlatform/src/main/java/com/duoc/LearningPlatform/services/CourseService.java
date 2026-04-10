package com.duoc.LearningPlatform.services;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.duoc.LearningPlatform.model.Course;


@Service
public class CourseService {

    private List<Course> courses = new ArrayList<>(); 

    public CourseService (){
        courses.add(new Course(111L,"Java basics", "Jack Black", true));
        courses.add(new Course(222L,"SQL", "Mary Wollstonecraft", true));
        courses.add(new Course(333L,"OOP", "Jane Austen", true));
    }



}
