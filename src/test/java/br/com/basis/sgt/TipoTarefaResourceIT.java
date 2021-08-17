package br.com.basis.sgt;

import br.com.basis.sgt.domain.TipoTarefa;
import br.com.basis.sgt.repository.TipoTarefaRepository;
import br.com.basis.sgt.service.dto.TipoTarefaDTO;
import br.com.basis.sgt.service.mapper.TipoTarefaMapper;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
public class TipoTarefaResourceIT implements SGTTestConfig {

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), StandardCharsets.UTF_8);

    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private Long idInexistente;

    @BeforeEach
    public void setUp() {
        idInexistente = 1000000000000000000L;
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                /*.apply(SecurityMockMvcConfigurers.springSecurity())*/.build();
    }

    @Autowired
    public void setWebApplicationContext(WebApplicationContext pWebApplicationContext) {
        webApplicationContext = pWebApplicationContext;
    }


    protected MockMvc getMockMvc() {
        return mockMvc;
    }

    public static byte[] convertObjectToJsonBytes(Object object)
            throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        JavaTimeModule module = new JavaTimeModule();
        mapper.registerModule(module);

        return mapper.writeValueAsBytes(object);
    }

    @Autowired
    private TipoTarefaRepository tipoTarefaRepository;

    @Autowired
    private TipoTarefaMapper tipoTarefaMapper;

    @BeforeEach
    private void limparBanco() {
        tipoTarefaRepository.deleteAll();
    }


    @Test
    public Long salvarTipoTarefa(TipoTarefaDTO tipoTarefaDTO) {
        TipoTarefa save = tipoTarefaMapper.toEntity(tipoTarefaDTO);
        save = tipoTarefaRepository.save(save);
        return save.getId();
    }


    @Test
    public void criarTipoTarefa() throws Exception {
        TipoTarefaDTO tipoTarefaDTO = getTipoTarefaDTO();

        getMockMvc().perform(
                post("/api/tipotarefas")
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(convertObjectToJsonBytes(tipoTarefaDTO))
        ).andExpect(status().isOk());
    }


    @Test
    public void obterPorIdComSucesso() throws Exception {
        Long idTipoTarefa = salvarTipoTarefa(getTipoTarefaDTO());

        getMockMvc().perform(
                get("/api/tipotarefas/" + idTipoTarefa)
                        .contentType(APPLICATION_JSON_UTF8)
        ).andExpect(status().isOk());
    }


    @Test
    public void obterPorIdComError() throws Exception {
        salvarTipoTarefa(getTipoTarefaDTO());
        getMockMvc().perform(
                get("/api/tipotarefas/" + Long.MAX_VALUE)
                        .contentType(APPLICATION_JSON_UTF8)
        ).andExpect(status().isNotFound());
    }


    private TipoTarefaDTO getTipoTarefaDTO() {
        TipoTarefaDTO tipoTarefaDTO = new TipoTarefaDTO();
        tipoTarefaDTO.setDescricao("descricao 1");
        return tipoTarefaDTO;
    }


    @Test
    public void deletetarTipoTarefa() throws Exception {
        Long idTipoTarefa = salvarTipoTarefa(getTipoTarefaDTO());
        getMockMvc().perform(
                delete("/api/tipotarefas/" + idTipoTarefa)
                        .contentType(APPLICATION_JSON_UTF8)
        ).andExpect(status().isOk());
    }

    @Test
    public void obterTodosSem() throws Exception {
        salvarTipoTarefa(getTipoTarefaDTO());
        getMockMvc().perform(

                get("/api/tipotarefas/")
                        .contentType(APPLICATION_JSON_UTF8)
        ).andExpect(status().isOk());
    }

    @Test
    public void obterTodoss() throws Exception {
        salvarTipoTarefa(getTipoTarefaDTO());
        getMockMvc().perform(

                get("/api/tipotarefas/?descricao=sdad")
                        .contentType(APPLICATION_JSON_UTF8)
        );
    }


}