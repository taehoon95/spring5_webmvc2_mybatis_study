package spring5_webmvc2_mybatis_study.exception;

@SuppressWarnings("serial")
public class MemberNotFoundException extends RuntimeException{

	public MemberNotFoundException() {
	}

	public MemberNotFoundException(String message) {
		super(message);
	}

}
