package org.chen.arch.core.exception;

import javax.servlet.http.HttpServletRequest;

import org.chen.arch.core.support.ReturnData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 统一异常处理
 * @author Chengang
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	public static final String DEFAULT_ERROR_VIEW = "error";

	/**
	 * 通用异常，跳转到错误页
	 * @param req
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("exception", e);
		mv.addObject("url", req.getRequestURL());
		mv.setViewName(DEFAULT_ERROR_VIEW);
		return mv;
	}
	
	/**
	 * 自定义业务异常，返回错误json数据
	 * @param req
	 * @param e
	 * @return
	 */
	@ExceptionHandler(BusinessException.class)
	@ResponseBody
	public ReturnData<String> businessErrorHandler(HttpServletRequest req, Exception e){
		ReturnData<String> returnData = new ReturnData<>();
		returnData.setFail(e.getMessage());
		//TODO 此处可以保存错误信息
		
		return returnData;
	}
	
	
	
}
