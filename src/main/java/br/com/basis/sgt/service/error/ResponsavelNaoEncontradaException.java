package br.com.basis.sgt.service.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResponsavelNaoEncontradaException extends RuntimeException {

    public ResponsavelNaoEncontradaException(Long id) {

        super("Responsável com ID " + id + " não encontrado!");
    }
}
