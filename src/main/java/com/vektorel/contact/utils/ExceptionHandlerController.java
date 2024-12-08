package com.vektorel.contact.utils;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException exp){
		return new ResponseEntity<>("Hata: Aranan Kayıt Bulunamadı. "+exp.getMessage()+"-"+exp.getCause(),HttpStatus.OK);
	
	}
	
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<String> handleSqlexception(SQLIntegrityConstraintViolationException exp){
		return new ResponseEntity<>("Hata: Aynı isimde başka bir kayıt var. ",HttpStatus.OK);
	}

}
