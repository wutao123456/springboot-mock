package com.dlh.wutao.exceptionhandler;

import com.dlh.wutao.entity.ErrorInfo;
import com.dlh.wutao.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wutao
 * @email wutao56789@gmail.com
 * @date 2018/10/23 21:34
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request,Exception e)throws Exception{
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception",e);
        mav.addObject("url",request.getRequestURL());
        mav.setViewName("error");
        return mav;
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest request, Exception e){
        ErrorInfo<String> errorInfo = new ErrorInfo<>();
        errorInfo.setCode(100);
        errorInfo.setMessage(e.getMessage());
        errorInfo.setUrl(request.getRequestURL().toString());
        errorInfo.setData("some data");
        return errorInfo;
    }
}
