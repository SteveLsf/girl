package com.lsf.girl.exception;

import com.lsf.girl.enums.ResultEnum;

/**
 * Created by sifo
 * 2018-09-11 10:48
 */
//继承自RuntimeException 会进行事务回滚
public class GirlException extends RuntimeException {
    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
