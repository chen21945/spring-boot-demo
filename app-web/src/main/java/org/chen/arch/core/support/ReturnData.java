package org.chen.arch.core.support;

/**
 * 接口返回数据
 * @author Chengang
 *
 * @param <T>
 */
public class ReturnData<T> {

	private String code;
	
	private T data;
	
	private String totalCount;

	private String errorMsg;
	
	public ReturnData(){
		this.code = ReturnCode.SUCCESS;
	}
	
	public void setSuccess(){
		this.code = ReturnCode.SUCCESS;
		this.errorMsg = "";
	}
	
	public void setFail(){
		this.code = ReturnCode.FAILURE;
	}
	
	public void setFail(String errorMsg){
		this.code = ReturnCode.FAILURE;
		this.errorMsg = errorMsg;
	}
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
}
