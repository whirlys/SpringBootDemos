package com.xuli.utils;

import com.xuli.domain.Result;
import com.xuli.enums.ResultEnum;

/**
 * Created by Administrator on 2017/7/18.
 */
public class ResultUtil {
    /**
     * 共通方法：成功的情况
     * @param object
     * @return
     */
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    /**
     * 共通方法：成功的情况，data是null
     * @return
     */
    public static Result success(){
        return success(null);
    }

    /**
     * 共通方法：失败的情况
     * @param code
     * @param msg
     * @return
     */
    public static Result error(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
