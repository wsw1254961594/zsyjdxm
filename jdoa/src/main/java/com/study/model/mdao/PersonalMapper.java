package com.study.model.mdao;

import com.study.pojo.Personal;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PersonalMapper {
    Integer insert(String password,Integer empno);
}
