package com.ihrm.common.exception;

import com.ihrm.common.entity.ResultCode;
import lombok.Getter;

@Getter
public class CommonException extends Exception {

    private ResultCode resultCode;

    public CommonException (ResultCode resultCode){
        this.resultCode = resultCode;
    }
}
