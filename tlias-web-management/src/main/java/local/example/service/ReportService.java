package local.example.service;

import local.example.pojo.JobOption;
import local.example.pojo.Student;
import local.example.pojo.StudentCount;

import java.util.List;
import java.util.Map;

public interface ReportService {
    List<Map<String, Object>> genderList();

    JobOption jobMap();

    List<Map<String, Object>> degreeList();

    StudentCount studentCount();

}
