package com.es.user.jwt.controller;

import com.es.user.jwt.entity.User;
import com.es.user.jwt.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.es.user.jwt.util.JSONUtil.safeToJson;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void login() throws Exception {
        User user = new User().setName("Weison").setPassword("123456");
        when(userService.getByName(anyString())).thenReturn(user);
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(safeToJson(user))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.payload.id").value(user.getId()));
    }

    @Test
    public void getUsers() throws Exception {
        User user = new User().setName("Weison").setPassword("123456");
        when(userService.getByName(anyString())).thenReturn(user);
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/v1/account/getAccount")
                .contentType(MediaType.APPLICATION_JSON)
                .param("name", "Weison")
                .accept(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk());
        resultActions
                .andExpect(jsonPath("$.payload").value("123"));
    }
}
