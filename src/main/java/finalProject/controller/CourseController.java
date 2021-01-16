package finalProject.controller;


import finalProject.errors.ResourceNotFoundException;
import finalProject.models.Course;
import finalProject.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    @GetMapping("/courses/{courseId}")
    public ResponseEntity<Course> findCourseById(@PathVariable(value = "courseId") Long courseID)
        throws ResourceNotFoundException {
        Course course = courseRepository.findById(courseID)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id::" + courseID));
        return ResponseEntity.ok().body(course);
    }

    @PostMapping("/courses")
    public Course addCourse(@Valid @RequestBody Course course) {
        courseRepository.save(course);
        return course;
    }

    @PutMapping("/courses")
    public ResponseEntity<Course> updateCourse(@Valid @RequestBody Course courseDetails)
        throws ResourceNotFoundException {
        Course course = courseRepository.findById(courseDetails.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id::" + courseDetails.getCourseId()));
        course.setCourseId(courseDetails.getCourseId());
        course.setCsDate(courseDetails.getCsDate());
        course.setCsName(courseDetails.getCsName());
        course.setDetails(courseDetails.getDetails());
        course.setTrainerLs(courseDetails.getTrainerLs());

        final Course updatedCourse = courseRepository.save(course);
        return ResponseEntity.ok(updatedCourse);
    }

    @DeleteMapping("/courses/{courseId}")
    public Map<String, Boolean> deleteCourse(@PathVariable(value ="courseId") Long courseID)
        throws ResourceNotFoundException {
        Course course = courseRepository.findById(courseID)
                .orElseThrow(()-> new ResourceNotFoundException("Course not found for this id::" + courseID));
        courseRepository.delete(course);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
     }

}
