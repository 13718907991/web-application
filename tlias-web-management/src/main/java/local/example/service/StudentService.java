package local.example.service;

import local.example.pojo.Student;
import local.example.pojo.StudentPageParam;

import java.util.List;

public interface StudentService {
    Integer count();

    List<Student> searchStudentByConditions(StudentPageParam studentPageParam);

    void deleteStudentsByIds(List<Integer> ids);

    void addStudent(Student student);

    Student searchStudentById(Integer id);

    void updateStudentById(Student student);

    void updateStudentViolationById(Integer id, Short score);
}
