package com.studentapp.dao;

import com.studentapp.model.Student;

public interface StudentDAO {
    void addStudent(Student s);
    Student getStudent(int id);
    void updateStudent(Student s);
    void deleteStudent(int id);
}
