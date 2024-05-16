package com.gugu.utils;

import com.gugu.common.ResultResponse;

/**
 * @author Gugu
 * @create 2023-04-26 15:17
 * @purpose
 */
public class ReturnUtil {

    public static ResultResponse returnResult(Integer i, String success, String error){
        if (i==1){
            return ResultResponse.success(success);
        }
        return  ResultResponse.error(error);
    }
}
