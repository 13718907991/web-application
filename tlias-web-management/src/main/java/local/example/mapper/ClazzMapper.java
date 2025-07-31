package local.example.mapper;

import local.example.pojo.Clazz;
import local.example.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClazzMapper {
    @Select("select count(*) from clazz")
    Integer clazzCount(ClazzQueryParam clazzQueryParam);

    List<Clazz> clazzList(ClazzQueryParam clazzQueryParam);

    @Delete("delete from clazz where id = #{id}")
    void deleteClazzById(Integer id);

    @Insert("insert into clazz (name, room, begin_date, end_date, master_id, subject, create_time, update_time) "
            + "values (#{name}, #{room}, #{beginDate}, #{endDate}, #{masterId}, "
            + "#{subject}, #{createTime}, #{updateTime})")
    void addClazz(Clazz clazz);

    @Select("select id, name, room, begin_date, end_date, master_id, "
            + "subject, create_time, update_time from clazz where id=#{id}")
    Clazz searchClazzById(Integer id);

    @Update("update clazz set id=#{id}, name=#{name}, room=#{room}, begin_date=#{beginDate}, "
            + "end_date=#{endDate}, master_id=#{masterId}, subject=#{subject}, update_time=#{updateTime} where id=#{id}")
    void updateClazzById(Clazz clazz);

    @Select("select id, name, room, begin_date, end_date, master_id, subject, create_time, update_time from clazz")
    List<Clazz> searchAllClazz();
}
