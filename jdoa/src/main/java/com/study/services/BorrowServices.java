package com.study.services;

import com.study.model.mdao.IBorrowMapper;
import com.study.pojo.Borrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Li-xing Chen
 * @version 1.8
 * @date 2020/12/21 20:42
 * @Description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BorrowServices {
    @Autowired
    IBorrowMapper borrowMapper;

    /*查询资产借用表*/
    public List<Borrow> selectBorrwAll(){
        return borrowMapper.selectBorrowAll();
    }

}
