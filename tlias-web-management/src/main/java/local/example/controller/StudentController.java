package local.example.controller;

import local.example.pojo.Result;
import local.example.pojo.Student;
import local.example.pojo.StudentPageParam;
import local.example.pojo.StudentPageResult;
import local.example.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    public Result searchStudentsByConditions(StudentPageParam studentPageParam) {
        log.info("查询学生信息, studentPageParam={}", studentPageParam);
        Integer total = studentService.count();
        List<Student> studentList =studentService.searchStudentByConditions(studentPageParam);
        return Result.success(new StudentPageResult(total, studentList));
    }

    @DeleteMapping("/{ids}")
    public Result deleteStudentsByIds(@PathVariable List<Integer> ids) {
        log.info("删除学生信息, ids={}", ids);
        studentService.deleteStudentsByIds(ids);
        return Result.success();
    }

    @PostMapping
    public Result addStudent(@RequestBody Student student) {
        log.info("添加学生信息, student={}", student);
        studentService.addStudent(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result searchStudentById(@PathVariable Integer id) {
        log.info("查询学生信息, id={}", id);
        Student student = studentService.searchStudentById(id);
        return Result.success(student);
    }

    @PutMapping
    public Result updateStudentById(@RequestBody Student student) {
        log.info("更新学生信息, student={}", student);
        studentService.updateStudentById(student);
        return Result.success();
    }

    @PutMapping("/violation/{id}/{score}")
    public Result updateStudentViolationById(@PathVariable Integer id, @PathVariable Short score) {
        log.info("更新学生信息, id={}, score={}", id, score);
        studentService.updateStudentViolationById(id, score);
        return Result.success();
    }
}
