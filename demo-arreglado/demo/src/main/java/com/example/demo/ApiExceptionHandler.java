package com.example.demo;
import org.springframework.http.*; import org.springframework.web.bind.MethodArgumentNotValidException; import org.springframework.web.bind.annotation.*; import org.springframework.http.converter.HttpMessageNotReadableException; import java.util.*;
@RestControllerAdvice
public class ApiExceptionHandler {
 @ExceptionHandler(NoSuchElementException.class) public ResponseEntity<Map<String,String>> notFound(NoSuchElementException e){return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error",e.getMessage()));}
 @ExceptionHandler(IllegalArgumentException.class) public ResponseEntity<Map<String,String>> badRequest(IllegalArgumentException e){return ResponseEntity.badRequest().body(Map.of("error",e.getMessage()));}
 @ExceptionHandler(MethodArgumentNotValidException.class) public ResponseEntity<Map<String,Object>> validation(MethodArgumentNotValidException e){String msg=e.getBindingResult().getFieldErrors().stream().map(x->x.getField()+": "+x.getDefaultMessage()).findFirst().orElse("Datos inválidos");return ResponseEntity.badRequest().body(Map.of("error","Validación fallida","detalle",msg));}
 @ExceptionHandler(HttpMessageNotReadableException.class) public ResponseEntity<Map<String,String>> unreadable(HttpMessageNotReadableException e){return ResponseEntity.badRequest().body(Map.of("error","JSON inválido o tipo de movimiento incorrecto. Usa INGRESO, GASTO o APORTE."));}
}
