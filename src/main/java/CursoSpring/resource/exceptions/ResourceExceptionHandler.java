package CursoSpring.resource.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import CursoSpring.services.exceptions.DataBaseException;
import CursoSpring.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardErro> resourceNotFound(ResourceNotFoundException e ,HttpServletRequest request){
		String error = "resourse not found";
		HttpStatus status= HttpStatus.NOT_FOUND;
		StandardErro err = new StandardErro(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardErro> DataBaseException(DataBaseException e ,HttpServletRequest request){
		String error = "DataBase Error";
		HttpStatus status= HttpStatus.BAD_REQUEST;
		StandardErro err = new StandardErro(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}


}
