package local.example.mapper;

import local.example.pojo.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
@SuppressWarnings("all")
public interface EmpMapper {
    List<Emp> page(EmpQueryParam empQueryParam);

    @Select("select count(*) from emp left join dept on emp.dept_id = dept.id")
    Integer count();

    void addEmp(Emp emp);

    void addEmpExprs(List<EmpExpr> exprList);

    @Delete("delete from emp where id = #{id}")
    void deleteEmpById(Integer id);

    @Select("select id, username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time from emp where id = #{id}")
    Emp searchEmpById(Integer id);

    void updateEmpById(Emp emp);

    @Select("select id, username, name from emp where username=#{username} and password=#{password}")
    LoginInfo searchLoginInfo(Login info);
}
