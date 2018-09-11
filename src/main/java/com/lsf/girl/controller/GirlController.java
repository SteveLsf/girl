package com.lsf.girl.controller;

import com.lsf.girl.domain.Girl;
import com.lsf.girl.domain.Result;
import com.lsf.girl.repository.GirlRepository;
import com.lsf.girl.service.GirlService;
import com.lsf.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by sifo
 * 2018-09-06 16:50
 */
@RestController
public class GirlController {
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表信息
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        logger.info("girlList");
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生信息
     * @param girl
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        girl.setMoney(girl.getMoney());

        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 查找一个女生信息
     * @param id
     * @return
     */
    @GetMapping(value = "girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }

    /**
     * 更新一个女生信息
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value = "girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @PathVariable("cupSize") String cupSize,
                           @PathVariable("age") Integer age) {
        Girl girl = girlRepository.findOne(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 根据ID删除女生信息
     * @param id
     */
    @DeleteMapping(value = "girlsDel/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

    /**
     * 根据女生年龄查询女生信息
     * @param age
     * @return
     */
    @GetMapping(value = "girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    /**
     * 同时插入两个女生信息
     */
    @PostMapping(value = "girls/insertTwo")
    public void girlInsertTwo() {
        girlService.insertTwo();
    }

    @GetMapping(value = "girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }
}
