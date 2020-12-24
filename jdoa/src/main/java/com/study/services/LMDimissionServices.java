package com.study.services;

import com.study.model.mdao.ILMdimissionMapper;
import com.study.pojo.Dimission;
import com.study.pojo.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: LiaoMiao
 * @Description:
 * @Date: create in 2020/12/24 14:42
 */
@Service
public class LMDimissionServices {
    @Autowired
    ILMdimissionMapper mdimissionMapper;

    //新增离职
    public Integer insert(Dimission dimission){
        try {
            return mdimissionMapper.insert(dimission);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    public Integer selectmax(){
        Integer list=mdimissionMapper.selectmax();
        return list;
    }
}
