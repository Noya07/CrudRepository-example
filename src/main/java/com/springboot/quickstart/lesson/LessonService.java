package com.springboot.quickstart.lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> getAllLessons(String courseId){
        List<Lesson> cours = new ArrayList<>();
        lessonRepository.findByCourseId(courseId)
                .forEach(cours::add);
        return cours;
    }

    public Lesson getLesson(String id){
       return lessonRepository.findOne(id);
    }

    public void addLesson(Lesson lesson){
        lessonRepository.save(lesson);
    }

    public void updateLesson(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    public void deleteLesson(String id) {
        lessonRepository.delete(id);
    }
}
