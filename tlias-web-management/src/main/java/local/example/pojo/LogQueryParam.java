package local.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogQueryParam {
    private Integer page = 1;
    private Integer pageSize = 10;
    private Integer offset;
}
