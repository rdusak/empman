package rdusak.demo.empman.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DetailedExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		DetailedError detailedError = new DetailedError(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(detailedError, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		DetailedError detailedError = new DetailedError(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(detailedError, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
