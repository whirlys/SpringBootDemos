package com.xuli.handle;

import com.xuli.domain.Result;
import com.xuli.enums.ResultEnum;
import com.xuli.exception.GirlExpection;
import com.xuli.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/7/18.
 */
@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof GirlExpection) {
            GirlExpection girlExpection = (GirlExpection) e;
            return ResultUtil.error(girlExpection.getCode(), girlExpection.getMessage());
        } else {
            return ResultUtil.error(ResultEnum.UNKONW_ERROR.getCode(), ResultEnum.UNKONW_ERROR.getMsg());
        }
    }
}
