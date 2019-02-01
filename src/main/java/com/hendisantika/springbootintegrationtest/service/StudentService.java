package com.hendisantika.springbootintegrationtest.service;

import com.hendisantika.springbootintegrationtest.model.Student;
import com.hendisantika.springbootintegrationtest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-integrationtest
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-02-01
 * Time: 08:06
 * To change this template use File | Settings | File Templates.
 */
@Component
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<Student> createStudent() {
        List<Student> students = new ArrayList<Student>();
        List<Student> savedStudents = new ArrayList<Student>();

        students.add(new Student("Uzumaki Naruto", "Class 10"));
        students.add(new Student("Uchiha Sasuke", "Class 9"));
        students.add(new Student("Haruno Sakura", "Class 10"));
        students.add(new Student("Hatake Kakashi", "Class 10"));
        Iterable<Student> itrStudents = repository.saveAll(students);
        itrStudents.forEach(savedStudents::add);

        return savedStudents;
    }

    public Iterable<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student retrieveStudent(Integer studentId) {
        return repository.findById(studentId).orElse(new Student());

    }

}