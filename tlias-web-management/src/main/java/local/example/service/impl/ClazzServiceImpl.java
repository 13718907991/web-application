package local.example.service.impl;

import local.example.mapper.ClazzMapper;
import local.example.pojo.Clazz;
import local.example.pojo.ClazzQueryParam;
import local.example.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public Integer clazzCount(ClazzQueryParam clazzQueryParam) {
        return clazzMapper.clazzCount(clazzQueryParam);
    }

    @Override
    public List<Clazz> clazzList(ClazzQueryParam clazzQueryParam) {
        Integer offset = (clazzQueryParam.getPage() - 1) * clazzQueryParam.getPageSize();
        clazzQueryParam.setOffset(offset);

        LocalDate queryParamBegin = clazzQueryParam.getBegin();
        LocalDate queryParamEnd = clazzQueryParam.getEnd();

        List<Clazz> clazzList = clazzMapper.clazzList(clazzQueryParam);
        clazzList.forEach(clazz -> {
            if (LocalDate.now().isBefore(clazz.getBeginDate())) {
                clazz.setStatus("未开始");
            } else if (LocalDate.now().isAfter(clazz.getEndDate())) {
                clazz.setStatus("已结束");
            } else clazz.setStatus("进行中");
        });

        return clazzList.stream().filter(clazz -> hasOverlapped(clazz, queryParamBegin, queryParamEnd)).toList();
    }

    @Override
    public void deleteClazzById(Integer id) {
        clazzMapper.deleteClazzById(id);
    }

    @Override
    public void addClazz(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.addClazz(clazz);
    }

    @Override
    public Clazz searchClazzById(Integer id) {
        return clazzMapper.searchClazzById(id);
    }

    @Override
    public void updateClazzById(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.updateClazzById(clazz);
    }

    public Boolean hasOverlapped(Clazz clazz, LocalDate begin, LocalDate end) {
        if (begin == null || end == null) return true;
        if (begin.isBefore(clazz.getBeginDate()) && end.isAfter(clazz.getEndDate())) {
            return true;
        } else if (begin.isAfter(clazz.getBeginDate()) && begin.isBefore(clazz.getEndDate())) {
            return true;
        } else return end.isAfter(clazz.getBeginDate()) && end.isBefore(clazz.getEndDate());
    }

    @Override
    public List<Clazz> searchAllClazz() {
        return clazzMapper.searchAllClazz();
    }
}
