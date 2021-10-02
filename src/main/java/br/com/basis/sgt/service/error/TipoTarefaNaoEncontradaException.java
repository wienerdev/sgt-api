package br.com.basis.sgt.service.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TipoTarefaNaoEncontradaException extends RuntimeException {

    public TipoTarefaNaoEncontradaException(Long id) {

        super("Tipo de tarefa com ID " + id + " não encontrado!");
    }
}
