package com.study.model.mdao;

import com.study.pojo.Positive;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IpositiveMapper {
    int insert(Positive positive);

    Integer selectmax();
}
