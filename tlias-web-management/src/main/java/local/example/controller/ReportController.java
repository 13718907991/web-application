package local.example.controller;

import local.example.pojo.Result;
import local.example.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/empGenderReport")
    public Result getGenderData() {
        return Result.success(reportService.genderList());
    }

    @GetMapping("/empJobReport")
    public Result getJobData() {
        return Result.success(reportService.jobMap());
    }

    @GetMapping("/studentDegreeReport")
    public Result getDegreeData() {
        return Result.success(reportService.degreeList());
    }

    @GetMapping("/studentCountData")
    public Result getStudentCountData() {
        return Result.success(reportService.studentCount());
    }
}
