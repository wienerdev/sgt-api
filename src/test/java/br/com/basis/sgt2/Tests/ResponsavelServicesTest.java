package br.com.basis.sgt2.Tests;


import br.com.basis.sgt2.Service.DTO.ResponsavelDTO;
import br.com.basis.sgt2.Service.ResponsavelServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
public class ResponsavelServicesTest {

    @Autowired
    private ResponsavelServices responsavelServices;


    private long idExistente;
    private long idInexistente;
    private int quantidadeResponsavel;

    @BeforeEach
    void setDados() throws Exception{
        idExistente = 1L;
        idInexistente = 999L;
        quantidadeResponsavel = 3;

    }

    @Test
    public void obterTodosResponsaveis(){
        List<ResponsavelDTO> lista = responsavelServices.obterTodos();

        Assertions.assertFalse(lista.isEmpty());
        Assertions.assertEquals(lista.size(),quantidadeResponsavel);

    }

}
