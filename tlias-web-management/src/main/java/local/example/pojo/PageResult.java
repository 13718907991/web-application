package local.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult {
    private Integer total; //总记录数
    private List<Emp> rows; //当前页数据列表
}