package br.com.sicredi.assembleia.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorApiResponse {

	private int status;
	private String type;
	private String title;
	private String message;
	private String description;
	private LocalDateTime timestamp;
}
