package br.com.basis.sgt2.serviceTest;

import br.com.basis.sgt2.dto.TasksDTO;
import br.com.basis.sgt2.dto.mapper.TasksMapper;
import br.com.basis.sgt2.entities.Tasks;
import br.com.basis.sgt2.entities.enums.EnumProgress;
import br.com.basis.sgt2.repositories.TasksRepository;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@SpringBootTest
@Transactional
public class TaskResourceIT {

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), StandardCharsets.UTF_8);

    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Autowired
    public void setWebApplicationContext(WebApplicationContext pWebApplicationContext){
        webApplicationContext = pWebApplicationContext;
    }

    protected MockMvc getMockMvc(){
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
    private TasksRepository tasksRepository;

    @Autowired
    private TasksMapper tasksMapper;

    @BeforeEach
    private void cleanData(){
        tasksRepository.deleteAll();
    }

    @Test
    public void findAllTask() throws Exception{
        saveTask(getTaskDTO());
        getMockMvc().perform(
                get("/api/task/")
                        .contentType(APPLICATION_JSON_UTF8)
        ).andExpect(status().isOk());
    }

    @Test
    public void findByTitle() throws Exception{
        String title = saveTaskTitle(getTaskDTO());
        getMockMvc().perform(
                get("/api/task/?" + title)
                        .contentType(APPLICATION_JSON_UTF8)
        ).andExpect(status().isOk());
    }

//    @Test
//    public void byTitleError() throws Exception{
//        saveTaskTitle(getTaskDTO());
//        getMockMvc().perform(
//                get("/api/task/?" )
//                        .contentType(APPLICATION_JSON_UTF8)
//        ).andExpect(status().isNotFound());
//    }

    @Test
    public void newTask() throws Exception {
        TasksDTO tasksDTO = getTaskDTO();
        getMockMvc().perform(
                post("/api/task/")
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(convertObjectToJsonBytes(tasksDTO))
        ).andExpect(status().isOk());
    }



    @Test
    public void byIdWithSuccessful() throws Exception{
        Long idTask = saveTask(getTaskDTO());
        getMockMvc().perform(
                get("/api/task/" + idTask)
                .contentType(APPLICATION_JSON_UTF8)
                ).andExpect(status().isOk());
    }

    @Test
    public void byIdWithError() throws Exception{
        saveTask(getTaskDTO());
        getMockMvc().perform(
                get("/api/task/" + Long.MAX_VALUE)
                .contentType(APPLICATION_JSON_UTF8)
        ).andExpect(status().isNotFound());
    }

    @Test
    public void deleteTask() throws Exception{
        Long idUser = saveTask(getTaskDTO());
        getMockMvc().perform(
                delete("/api/task/" + idUser)
                        .contentType(APPLICATION_JSON_UTF8)
        ).andExpect(status().isOk());
    }

    private TasksDTO getTaskDTO() {
        TasksDTO tasksDTO = new TasksDTO();
        tasksDTO.setTitle("Title 1");
        tasksDTO.setDescription("Description");
        tasksDTO.setProgress(EnumProgress.DOING);
        tasksDTO.setUser((long) 1);
        tasksDTO.setComments(new ArrayList<>());
        return  tasksDTO;
    }

    private Long saveTask(TasksDTO tasksDTO){
        Tasks save = tasksRepository.save(tasksMapper.toEntity(tasksDTO));
        return save.getId();
    }
    private String saveTaskTitle(TasksDTO tasksDTO){
        Tasks save = tasksRepository.save(tasksMapper.toEntity(tasksDTO));
        return save.getTitle();
    }
}
