package com.gugu.common;

import lombok.Data;

/**
 * @author Gugu
 * @create 2023-04-23 21:14
 * @purpose 统一返回对象
 */
@Data
public class ResultResponse {
    private String code;
    private String message;
    private Object data;

    public static ResultResponse success(String message){
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setCode(ResultType.OK.value());
        resultResponse.setMessage(message);
        return resultResponse;
    }

    public static ResultResponse success(String message, Object data){
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setMessage(message);
        resultResponse.setData(data);
        resultResponse.setCode(ResultType.OK.value());
        return resultResponse;
    }

    public static ResultResponse info(String message){
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setMessage(message);
        resultResponse.setCode(ResultType.WARNING.value());
        return resultResponse;
    }

    public static ResultResponse info(ResultType result){
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setMessage(result.getMsg());
        resultResponse.setCode(result.value());
        return resultResponse;
    }

    public static ResultResponse error(String message){
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setMessage(message);
        resultResponse.setCode(ResultType.ERROR.value());
        return resultResponse;
    }

}
