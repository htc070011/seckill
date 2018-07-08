package com.bupt.miaoshao.exception;

import com.bupt.miaoshao.response.CodeMsg;
import com.bupt.miaoshao.response.TResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(value = Exception.class)
    public TResponse<String> exceptionHandler(Exception e) {
        if(e instanceof GlobalException) {
            return TResponse.errorTResponse(((GlobalException) e).getCodeMsg());
        } else if(e instanceof BindException) {
            BindException ex = (BindException) e;

            List<ObjectError> errors = ex.getAllErrors();

            return TResponse.errorTResponse(CodeMsg.INPUTEROOR.fillArgs(errors.get(0).getDefaultMessage()));

        }
        return TResponse.errorTResponse(CodeMsg.SERVERERROR.fillArgs(e.getMessage()));
    }
}
