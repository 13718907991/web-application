package local.example.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReportMapper {
    @MapKey("gender")
    List<Map<String, Object>> genderList();

    @MapKey("jobName")
    List<Map<String, Object>> jobList();

    @MapKey("degreeName")
    List<Map<String, Object>> degreeList();

    @MapKey("name")
    List<Map<String, Object>> studentCountList();
}
