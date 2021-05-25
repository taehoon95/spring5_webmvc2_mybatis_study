package spring5_webmvc2_mybatis_study.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;

@Controller
public class ListCommand {
	
	@DateTimeFormat(pattern = "yyyyMMddHH")
	private LocalDateTime from;

	@DateTimeFormat(pattern = "yyyyMMddHH")
	private LocalDateTime to;

	public LocalDateTime getFrom() {
		return from;
	}

	public void setFrom(LocalDateTime from) {
		this.from = from;
	}

	public LocalDateTime getTo() {
		return to;
	}

	public void setTo(LocalDateTime to) {
		this.to = to;
	}

}
