package com.lsf.girl.service;

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
}
