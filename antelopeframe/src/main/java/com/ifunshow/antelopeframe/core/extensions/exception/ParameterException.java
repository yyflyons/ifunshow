package com.ifunshow.antelopeframe.core.extensions.exception;

/**
 * (用一句话描述类的主要功能)
 * @author huangchunhua
 * @date 2011-12-20
 */

public class ParameterException extends RuntimeException {

	/** serialVersionUID */
	private static final long serialVersionUID = 6417641452178955756L;

	public ParameterException() {
		super();
	}

	public ParameterException(String message) {
		super(message);
	}

	public ParameterException(Throwable cause) {
		super(cause);
	}

	public ParameterException(String message, Throwable cause) {
		super(message, cause);
	}
}
