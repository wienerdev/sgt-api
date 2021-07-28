package br.com.basis.sgt2.serviceTest;

import br.com.basis.sgt2.dto.UserDTO;
import br.com.basis.sgt2.dto.mapper.UserMapper;
import br.com.basis.sgt2.entities.User;
import br.com.basis.sgt2.repositories.UserRepository;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;


@SpringBootTest
@Transactional
public class UserResourceIT {

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
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @BeforeEach
    private void cleanData(){
        userRepository.deleteAll();
    }

    @Test
    public void findAllUser() throws Exception{
        saveUser(getUserDTO());
        getMockMvc().perform(
                get("/api/users")
                        .contentType(APPLICATION_JSON_UTF8)
        ).andExpect(status().isOk());
    }

    @Test
    public void newUser() throws Exception {
        UserDTO userDTO = getUserDTO();
        getMockMvc().perform(
                post("/api/users/")
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(convertObjectToJsonBytes(userDTO))
        ).andExpect(status().isOk());
    }

    @Test
    public void userByIdWithSuccessful() throws Exception{
        Long idUser = saveUser(getUserDTO());
        getMockMvc().perform(
                get("/api/users/" + idUser)
                        .contentType(APPLICATION_JSON_UTF8)
        ).andExpect(status().isOk());
    }

    @Test
    public void userByIdWithError() throws Exception{
        saveUser(getUserDTO());
        getMockMvc().perform(
                get("/api/users/" + Long.MAX_VALUE)
                        .contentType(APPLICATION_JSON_UTF8)
        ).andExpect(status().isNotFound());
    }

    @Test
    public void deleteUser() throws Exception{
        Long idUser = saveUser(getUserDTO());
        getMockMvc().perform(
                delete("/api/users/" + idUser)
                            .contentType(APPLICATION_JSON_UTF8)
        ).andExpect(status().isOk());
    }

    private UserDTO getUserDTO() {
      UserDTO userDTO = new UserDTO();
        userDTO.setName("Nome 1");
        userDTO.setEmail("email@gmail.com");
        return userDTO;
    }

    private Long saveUser(UserDTO userDTO){
        User save = userRepository.save(userMapper.toEntity(userDTO));
        return save.getId();
    }
}
