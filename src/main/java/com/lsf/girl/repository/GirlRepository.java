package com.lsf.girl.repository;

import com.lsf.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by sifo
 * 2018-09-06 16:53
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    /**
     * 根据年龄查询女生列表信息
     * @param age
     * @return
     */
    public List<Girl> findByAge(Integer age);
}
