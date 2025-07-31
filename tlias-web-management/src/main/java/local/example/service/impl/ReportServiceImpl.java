package local.example.service.impl;

import local.example.mapper.ReportMapper;
import local.example.pojo.JobOption;
import local.example.pojo.StudentCount;
import local.example.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportMapper reportMapper;

    @Override
    public List<Map<String, Object>> genderList() {
        return reportMapper.genderList();
    }

    @Override
    public JobOption jobMap() {
        List<Map<String, Object>> jobList = reportMapper.jobList();
        List<Object> jobNameList = jobList.stream().map(jobMap -> jobMap.get("jobName")).toList();
        List<Object> dataList = jobList.stream().map(jobMap -> jobMap.get("total")).toList();
        return new JobOption(jobNameList, dataList);
    }

    @Override
    public List<Map<String, Object>> degreeList() {
        return reportMapper.degreeList();
    }

    @Override
    public StudentCount studentCount() {
        List<Map<String, Object>> studentCountList = reportMapper.studentCountList();
        List<Object> name =studentCountList.stream().map(studentCountMap -> studentCountMap.get("name")).toList();
        List<Object> value = studentCountList.stream().map(studentCountMap -> studentCountMap.get("value")).toList();
        return new StudentCount(name, value);
    }
}
