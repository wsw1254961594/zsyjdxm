package com.study.model.mdao;

import com.study.pojo.Emp;
import org.springframework.stereotype.Repository;

/**
 * @author: pengjia
 * @date: 2020/12/21
 * @description:
 */
@Repository
public interface IEmpMapper {
    Emp login(String ename);
}
