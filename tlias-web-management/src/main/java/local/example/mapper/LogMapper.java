package local.example.mapper;

import local.example.pojo.LogQueryParam;
import local.example.pojo.OperateLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogMapper {
    @Select("select * from operate_log limit #{offset}, #{pageSize}")
    List<OperateLog> page(LogQueryParam logQueryParam);

    @Select("select count(*) from operate_log")
    Integer count();
}
