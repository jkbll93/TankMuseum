package lesiak.jakub.Tank.Museum;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TankNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(TankNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String tankNotFoundHandler(TankNotFoundException ex){
        return ex.getMessage();
    }
}
