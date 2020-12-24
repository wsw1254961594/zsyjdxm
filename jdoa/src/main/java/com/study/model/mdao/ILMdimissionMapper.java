package com.study.model.mdao;

import com.study.pojo.Dimission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: LiaoMiao
 * @Description:
 * @Date: create in 2020/12/24 14:34
 */
@Mapper
@Repository
public interface ILMdimissionMapper {
    int insert(Dimission dimission);

    Integer selectmax();
}
