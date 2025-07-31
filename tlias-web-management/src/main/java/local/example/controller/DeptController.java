package local.example.controller;

import local.example.pojo.Dept;
import local.example.pojo.Result;
import local.example.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result allDepts() {
        log.info("查询部门列表");
        return Result.success(deptService.alldepts());
    }

    @DeleteMapping
    public Result deleteDeptById(Integer id) {
        log.info("根据id删除部门, id: {}" , id);
        deptService.deleteDeptById(id);
        return Result.success();
    }

    @PostMapping
    public Result addDept(@RequestBody Dept dept) {
        log.info("新增部门, dept: {}" , dept);
        deptService.addDept(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result searchDeptById(@PathVariable Integer id) {
        log.info("根据部门id查询, id: {}", id);
        Dept dept = deptService.searchDeptById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result updateDeptById(@RequestBody Dept dept) {
        log.info("修改部门, dept: {}" , dept);
        deptService.updateDeptById(dept);
        return Result.success();
    }
}
