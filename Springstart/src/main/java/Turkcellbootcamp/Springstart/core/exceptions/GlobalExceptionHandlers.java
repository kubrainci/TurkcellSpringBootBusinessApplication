package Turkcellbootcamp.Springstart.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandlers {

    @ExceptionHandler ({MethodArgumentNotValidException.class})
    public List<String>handleValidationException(MethodArgumentNotValidException exception){
        List<String>errors=new ArrayList<>();
        exception.getBindingResult().getAllErrors().forEach((error) ->{
            String fieldName = ((FieldError)error).getField();
            String errorMessage = error.getDefaultMessage();
            String message = fieldName + ":" + errorMessage;
            errors.add(message);
        });
        return errors;
    }

    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleValidationBusinessException(BusinessException exception){

        return exception.getMessage();
    }

}
