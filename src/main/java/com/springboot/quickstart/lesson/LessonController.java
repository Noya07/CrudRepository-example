package com.springboot.quickstart.lesson;

import com.springboot.quickstart.course.Course;
import com.springboot.quickstart.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @RequestMapping("/topics/{topicId}/courses/{id}/lessons")
    public List<Lesson> getAllCourses(@PathVariable String id){
        return lessonService.getAllLessons(id);
    }

    @RequestMapping("/topics/{topicId}/courses/{courseId}/lessons/{id}")
    public Lesson getCourse(@PathVariable String id){
        return lessonService.getLesson(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/topics/{topicId}/courses/{courseId}/lessons")
    public void addCourses(@RequestBody Lesson lesson, @PathVariable String courseId){
        lesson.setCourse(new Course(courseId, "", ""));
        lessonService.addLesson(lesson);
    }

    @RequestMapping(method= RequestMethod.PUT, value="/topics/{topicID}/courses/{courseId}/lessons/{id}")
    public void updateCourse(@RequestBody Lesson lesson, @PathVariable String courseId){
        lesson.setCourse(new Course(courseId, "", ""));
        lessonService.updateLesson(lesson);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/topics/{topicID}/courses/{courseId}/lessons/{id}")
    public void deleteCourse(@PathVariable String id){
        lessonService.deleteLesson(id);
    }

}
