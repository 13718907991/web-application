package local.example.mapper;

import local.example.pojo.Student;
import local.example.pojo.StudentPageParam;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("select count(*) from student")
    Integer count();

    @MapKey("id")
    List<Student> searchStudentByConditions(StudentPageParam studentPageParam);

    @Delete("delete from student where id = #{id}")
    void deleteStudentsById(Integer id);

    @Insert("insert into student(name, no, gender, phone, id_card, is_college, address, degree, graduation_date, clazz_id, violation_count, violation_score, create_time, update_time) " +
            "value (#{name}, #{no}, #{gender}, #{phone}, #{idCard}, #{isCollege}, #{address}, #{degree}, #{graduationDate}, #{clazzId}, #{violationCount}, #{violationScore}, #{createTime}, #{updateTime})")
    void addStudent(Student student);

    @Select("select id, name, no, gender, phone, id_card, is_college, address, degree, graduation_date, clazz_id, violation_count, violation_score, create_time, update_time from student where id = #{id}")
    Student searchStudentById(Integer id);

    @Update("update student set name= #{name}, no= #{no}, gender= #{gender}, phone= #{phone}, id_card= #{idCard}, is_college= #{isCollege}, address= #{address}, degree= #{degree}," +
            " graduation_date= #{graduationDate}, clazz_id= #{clazzId}, violation_count= #{violationCount}, violation_score= #{violationScore}, update_time=#{updateTime} where id=#{id}")
    void updateStudentById(Student student);

    @Update("update student set violation_count=violation_count+1, violation_score=violation_score+#{score}, update_time=#{updateTime} where id=#{id}")
    void updateStudentViolationById(Integer id, Short score, LocalDateTime updateTime);
}
