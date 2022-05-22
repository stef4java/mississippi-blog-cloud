package com.codergo.mississippi.common.base.exception;


import com.codergo.mississippi.common.base.dto.ResultCode;
import cn.hutool.core.util.StrUtil;
import lombok.Getter;
/**
 * 出自: http://www.ballcat.cn/
 */
@Getter
public class BusinessException extends RuntimeException {

	private final String message;

	private final int code;

	public BusinessException(ResultCode resultCode) {
		super(resultCode.getMessage());
		this.code = resultCode.getCode();
		this.message = resultCode.getMessage();
	}

	/**
	 * 用于需要format返回结果的异常
	 * @author lingting 2021-04-13 14:25
	 */
	public BusinessException(ResultCode resultCode, Object... args) {
		this(resultCode.getCode(), StrUtil.format(resultCode.getMessage(), args));
	}

	public BusinessException(ResultCode resultCode, Throwable e) {
		super(resultCode.getMessage(), e);
		this.code = resultCode.getCode();
		this.message = resultCode.getMessage();
	}

	/**
	 * 用于需要format返回结果的异常
	 * @author lingting 2021-04-13 14:25
	 */
	public BusinessException(ResultCode resultCode, Throwable e, Object... args) {
		this(resultCode.getCode(), StrUtil.format(resultCode.getMessage(), args), e);
	}

	public BusinessException(int code, String message) {
		super(message);
		this.message = message;
		this.code = code;
	}

	public BusinessException(int code, String message, Throwable e) {
		super(message, e);
		this.message = message;
		this.code = code;
	}

}