package com.sparta.spring1.apiresult;

public class ResultPrint {
    public static <T>ApiResult<T> success(T response) {
        return new ApiResult<>(true, response, null);
    }

}