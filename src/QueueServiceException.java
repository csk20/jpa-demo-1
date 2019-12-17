package com.dbs.messagingqueue.messagingqueueapi.exception;

import org.jboss.logging.Logger;

public class QueueServiceException extends RuntimeException {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public static final Logger logger= Logger.getLogger(QueueServiceException.class);
	
	public QueueServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QueueServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public QueueServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public QueueServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public QueueServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
