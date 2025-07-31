package local.example.service;

import local.example.pojo.Clazz;
import local.example.pojo.ClazzQueryParam;

import java.util.List;

public interface ClazzService {
    Integer clazzCount(ClazzQueryParam clazzQueryParam);

    List<Clazz> clazzList(ClazzQueryParam clazzQueryParam);

    void deleteClazzById(Integer id);

    void addClazz(Clazz clazz);

    Clazz searchClazzById(Integer id);

    void updateClazzById(Clazz clazz);

    List<Clazz> searchAllClazz();
}
