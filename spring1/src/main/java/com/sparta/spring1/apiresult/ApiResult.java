package com.sparta.spring1.apiresult;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResult<T>{
    private boolean success;
    private T data;
    private String error;

    public ApiResult(boolean success, T data,String message){
        this.success=success;
        this.data=data;
        this.error = message;
    }
}
