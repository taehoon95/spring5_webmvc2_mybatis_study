package spring5_webmvc2_mybatis_study.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("spring5_webmvc2_mybatis_study")
public class CommonExceptionHandler {
	@ExceptionHandler(RuntimeException.class)
	public String handleRuntimeException() {
		return "error/commomException";
	}
}
