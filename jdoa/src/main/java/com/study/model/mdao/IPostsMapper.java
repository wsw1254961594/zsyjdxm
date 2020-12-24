package com.study.model.mdao;

import com.study.pojo.Posts;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IPostsMapper {
    Integer insertpost(Posts posts);

    Integer selectmax();
}
