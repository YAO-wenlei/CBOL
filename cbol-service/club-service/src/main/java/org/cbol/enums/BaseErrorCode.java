package org.cbol.enums;

import org.cbol.common.errorcode.IErrorCode;

/**
 * @author yaowenlei
 */

public enum BaseErrorCode implements IErrorCode {
	PLAYER_NOT_FOUND("A000200","未查询到球员信息!")
	;
	/**
	 * 错误码
	 */
	private final String code;

	/**
	 * 错误信息
	 */
	private final String message;

	BaseErrorCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	@Override
	public String code() {
		return null;
	}

	@Override
	public String message() {
		return null;
	}
}
