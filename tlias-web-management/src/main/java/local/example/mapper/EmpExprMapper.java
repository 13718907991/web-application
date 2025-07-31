package local.example.mapper;

import local.example.pojo.EmpExpr;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    @Delete("delete from emp_expr where emp_id = #{empId}")
    void deleteEmpExprByEmpId(Integer empId);

    @Select("select id, emp_id, begin, end, company, job from emp_expr where emp_id = #{empId}")
    List<EmpExpr> searchEmpExprByEmpId(Integer empId);

    @Insert("insert into emp_expr (id, emp_id, begin, end, company, job) value  (#{id}, #{empId}, #{begin}, #{end}, #{company}, #{job})")
    void addEmpExpr(EmpExpr empExpr);
}
