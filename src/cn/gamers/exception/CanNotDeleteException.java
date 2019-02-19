package cn.gamers.exception;

public class CanNotDeleteException extends Exception{
	private static final long serialVersionUID = 1L;

	public CanNotDeleteException() {
		super();
	}

	public CanNotDeleteException(String message, Throwable cause) {
		super(message, cause);
	}

	public CanNotDeleteException(String message) {
		super(message);
	}

	public CanNotDeleteException(Throwable cause) {
		super(cause);
	}
}
