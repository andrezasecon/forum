package br.com.andrezasecon.forum.config.validacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice // Avisa o Spring que essa é uma classe que Interceptadora de exceções nas controllers
public class ErrorValidationHandler {

    @Autowired
    private MessageSource messageSource; // ajuda a pegar a mensagem de erro

    // Avisa ao Spring que esse método deve ser chamado se houver alguma exeção nas controlers
    @ExceptionHandler(MethodArgumentNotValidException.class) // Exception chamada
    @ResponseStatus(code = HttpStatus.BAD_REQUEST) // Avisa o Spring qual o status devolver ao cliente
    public List<ErrorFormDto> handle(MethodArgumentNotValidException exception){
        List<ErrorFormDto> dto = new ArrayList<>();

        List<FieldError> fieldError = exception.getBindingResult().getFieldErrors();
        fieldError.forEach(e -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale()); // seta a localização do usuário
            ErrorFormDto erro = new ErrorFormDto(e.getField(), mensagem);
            dto.add(erro);
        });

        return dto;
    }
}
