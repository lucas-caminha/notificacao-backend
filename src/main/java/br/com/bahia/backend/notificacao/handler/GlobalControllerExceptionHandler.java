package br.com.bahia.backend.notificacao.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.bahia.backend.notificacao.exception.GenericException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(GenericException.class)
	@ResponseBody
	public ResponseEntity<ErrorInfo> genericExceptionHandler(HttpServletRequest req, GenericException e) {
		ErrorInfo errorInfo = new ErrorInfo(req.getRequestURL().toString(), e.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorInfo);
	}
	
}
