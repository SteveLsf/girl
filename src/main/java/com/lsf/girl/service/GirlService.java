package com.lsf.girl.service;

import com.lsf.girl.enums.ResultEnum;
import com.lsf.girl.exception.GirlException;
import com.lsf.girl.repository.GirlRepository;
import com.lsf.girl.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by sifo
 * 2018-09-08 22:33
 */
@Service
public class GirlService {


    @Autowired
    private GirlRepository girlRepository;

    /**
     * 同时插入两个女生信息
     */
    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("BBB");
        girlB.setAge(18);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if(age < 10) {
            //返回“你还在上小学吧” code=100
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if(age > 10 && age < 16) {
            //返回“你可能在上初中” code=101
            throw new GirlException(ResultEnum.MIDDLE_SCHLOOL);
        }
    }
}
