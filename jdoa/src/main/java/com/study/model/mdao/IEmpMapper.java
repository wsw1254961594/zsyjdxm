package com.study.model.mdao;

import com.study.pojo.Dept;
import com.study.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IEmpMapper {
    List<Emp> selectall();

    /**
     * 根据emp获取部门，pj
     * @param empno
     * @return
     */
    Dept getDeptByEmp(Integer empno);

    /**
     * 请假业务类获取员工
     * @param empno
     * @return
     */
    Emp leavesGetEmp(Integer empno);
}