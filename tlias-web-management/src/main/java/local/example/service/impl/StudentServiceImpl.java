package local.example.service.impl;

import local.example.mapper.StudentMapper;
import local.example.pojo.Student;
import local.example.pojo.StudentPageParam;
import local.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Integer count() {
        return studentMapper.count();
    }

    @Override
    public List<Student> searchStudentByConditions(StudentPageParam studentPageParam) {
        Integer offset = (studentPageParam.getPage() - 1) * studentPageParam.getPageSize();
        studentPageParam.setOffset(offset);
        return studentMapper.searchStudentByConditions(studentPageParam);
    }

    @Override
    public void deleteStudentsByIds(List<Integer> ids) {
        if (ids != null && !ids.isEmpty()) {
            ids.forEach(id -> studentMapper.deleteStudentsById(id));
        }
    }

    @Override
    public void addStudent(Student student) {
        student.setViolationCount((short) 0);
        student.setViolationScore((short) 0);
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.addStudent(student);
    }

    @Override
    public Student searchStudentById(Integer id) {
        return studentMapper.searchStudentById(id);
    }

    @Override
    public void updateStudentById(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updateStudentById(student);
    }

    @Override
    public void updateStudentViolationById(Integer id, Short score) {
        LocalDateTime updateTime = LocalDateTime.now();
        studentMapper.updateStudentViolationById(id, score, updateTime);
    }
}
