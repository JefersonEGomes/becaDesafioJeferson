package com.becaJavaJeferson.exceptions.handle;

import com.becaJavaJeferson.exceptions.TamanhoNaoValidoException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.UnexpectedTypeException;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(TamanhoNaoValidoException.class)
    public ResponseEntity<DefaultException> handle(TamanhoNaoValidoException tamanhoNaoValido) {
        DefaultException defaultException = new DefaultException();
        defaultException.setMensagem(tamanhoNaoValido.getMessage());
        defaultException.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        defaultException.setDataAtual(LocalDateTime.now());

        return ResponseEntity.status(defaultException.getStatus()).body(defaultException);

    }

    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<DefaultException> handle(UnexpectedTypeException campoVazio) {
        DefaultException defaultException = new DefaultException();
        defaultException.setMensagem("Os campos obrigatórios estão vazios");
        defaultException.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        defaultException.setDataAtual(LocalDateTime.now());

        return ResponseEntity.status(defaultException.getStatus()).body(defaultException);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DefaultException> handle(MethodArgumentNotValidException campoInvalido) {
        DefaultException defaultException = new DefaultException();
        defaultException.setMensagem("Há campos inválidos, por favor revise");
        defaultException.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        defaultException.setDataAtual(LocalDateTime.now());

        return ResponseEntity.status(defaultException.getStatus()).body(defaultException);

    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<DefaultException> handle(HttpMessageNotReadableException dataInvalida) {
        DefaultException defaultException = new DefaultException();
        defaultException.setMensagem("Data inválida favor verificar novamente");
        defaultException.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        defaultException.setDataAtual(LocalDateTime.now());

        return ResponseEntity.status(defaultException.getStatus()).body(defaultException);

    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<DefaultException> handle(DataIntegrityViolationException dadoInvalido) {
        DefaultException defaultException = new DefaultException();
        defaultException.setMensagem("Você não pode apagar um dado que está sendo utilizado");
        defaultException.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        defaultException.setDataAtual(LocalDateTime.now());

        return ResponseEntity.status(defaultException.getStatus()).body(defaultException);

    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<DefaultException> run(NoSuchElementException dadoInvalido) {
        DefaultException defaultException = new DefaultException();
        defaultException.setMensagem("O id não foi encontrado");
        defaultException.setStatus(HttpStatus.NOT_FOUND.value());
        defaultException.setDataAtual(LocalDateTime.now());

        return ResponseEntity.status(defaultException.getStatus()).body(defaultException);

    }

}
