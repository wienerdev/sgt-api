package br.com.basis.sgt2.Tests;


import br.com.basis.sgt2.Domain.Enums.Status;
import br.com.basis.sgt2.Service.DTO.ResponsavelDTO;
import br.com.basis.sgt2.Service.DTO.TarefaDTO;
import br.com.basis.sgt2.Service.ResponsavelServices;
import br.com.basis.sgt2.Service.TarefaServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class TarefaServicesTest {

    @Autowired
    private TarefaServices tarefaServices;
    @Autowired
    private ResponsavelServices responsavelServices;

    private long idExistente;
    private long idInexistente;
    private int  quantidadeTarefas;

    @BeforeEach
    void setDadosTest() throws Exception{
        idExistente = 2l;
        idInexistente = 999L;
        quantidadeTarefas = 2;

    }

    @Test
    public void obterTodosDeveriaRetornarTodasTarefas(){
        List<TarefaDTO> lista = tarefaServices.obterTodos();
        Assertions.assertFalse(lista.isEmpty());
        Assertions.assertEquals(lista.size(),quantidadeTarefas);

    }
    @Test
    public void obterTarefaPorIdDeveriaObterUmaTarefa(){
    TarefaDTO tarefaDTO = tarefaServices.obterPorId(idExistente);
    Assertions.assertNotNull(tarefaDTO);

    }
    @Test
    public void obterTarefaDeveriaRetornarNuloQuandoIdInexistente(){
        TarefaDTO tarefaDTO = tarefaServices.obterPorId(idInexistente);
        Assertions.assertNull(tarefaDTO);


    }
    @Test
    public void salvarTarefaDeveriaSalvarUmaNovaTarefa(){
        TarefaDTO tarefaDTO = getTarefaDTO();
        tarefaDTO.setId(null);
        tarefaDTO = tarefaServices.salvar(tarefaDTO);
        TarefaDTO tarefaDTOsalvar = tarefaServices.obterPorId(tarefaDTO.getId());

        Assertions.assertNotNull(tarefaDTOsalvar.getId());

    }
    @Test
    public void atualizarTarefaDeveriaAtualizarUmaTarefa(){

        TarefaDTO tarefaDTO = getTarefaDTO();
        tarefaDTO.setId(idExistente);
        tarefaDTO = tarefaServices.atualizar(tarefaDTO);
        TarefaDTO tarefaDTOatualizar = tarefaServices.obterPorId(tarefaDTO.getId());

        Assertions.assertNotNull(tarefaDTOatualizar.getId());
    }
    @Test
    public void deletarTarefaDeveriaDeletarUmaTarefaPorId(){
        Assertions.assertDoesNotThrow(() ->{
            tarefaServices.deletarPorId(idExistente);
        });


    }





    private TarefaDTO getTarefaDTO(){
    TarefaDTO tarefaDTO = new TarefaDTO();
    tarefaDTO.setId(null);
    tarefaDTO.setDataInicio(LocalDate.now());
    tarefaDTO.setTerminoPrevisto(LocalDate.now());
    tarefaDTO.setHorasEfetivas(400);
    tarefaDTO.setStatus(Status.A_FAZER);
    tarefaDTO.setComentario(new ArrayList<>());
    ResponsavelDTO responsavelDTO = new ResponsavelDTO();
    tarefaDTO.setResponsavel(responsavelDTO);
    return tarefaDTO;
    }

}
