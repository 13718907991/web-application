package local.example.controller;

import local.example.anno.LogOperation;
import local.example.pojo.Clazz;
import local.example.pojo.ClazzPageResult;
import local.example.pojo.ClazzQueryParam;
import local.example.pojo.Result;
import local.example.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@SuppressWarnings("all")
@RequestMapping("/clazz")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

//    @LogOperation
    @GetMapping
    public Result allClazz(ClazzQueryParam clazzQueryParam) {
        Integer total = clazzService.clazzCount(clazzQueryParam);
        List<Clazz> clazzList =  clazzService.clazzList(clazzQueryParam);
        return Result.success(new ClazzPageResult(total, clazzList));
    }

    @DeleteMapping("/{id}")
    public Result deleteClazzById(@PathVariable Integer id) {
        clazzService.deleteClazzById(id);
        return Result.success();
    }

    @PostMapping
    public Result addClazz(@RequestBody Clazz clazz) {
        clazzService.addClazz(clazz);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result searchClazzById(@PathVariable Integer id) {
        Clazz clazz = clazzService.searchClazzById(id);
        return Result.success(clazz);
    }

    @PutMapping
    public Result updateClazzById(@RequestBody Clazz clazz) {
        clazzService.updateClazzById(clazz);
        return Result.success();
    }

    @GetMapping("/list")
    public Result clazzList() {
        List<Clazz> clazzList = clazzService.searchAllClazz();
        return Result.success(clazzList);
    }
}
