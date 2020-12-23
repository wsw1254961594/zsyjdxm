package com.study.model.jdao;

import com.study.pojo.Personal;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PersonalDAO extends CrudRepository<Personal,Integer> {
}
