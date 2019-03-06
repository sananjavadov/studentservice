package az.senan.studentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(StudentException.class)
	public ResponseEntity<Object> nfo(StudentException ex) {
		return new ResponseEntity<Object>(new ExceptionResponse(ex.getMessage()), HttpStatus.OK);
	}
}
