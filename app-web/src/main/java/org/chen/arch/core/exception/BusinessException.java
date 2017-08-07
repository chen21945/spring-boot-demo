package org.chen.arch.core.exception;

/**
 * 业务异常信息
 * @author Chengang
 *
 */
@SuppressWarnings("serial")
public class BusinessException extends RuntimeException{

	public BusinessException(String message){
		super(message);
	}
	
	public BusinessException(String message, Exception e){
		super(message, e);
	}
	
	public BusinessException(Exception e){
		super(e);
	}
}
