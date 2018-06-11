package com.example.hibernate.rest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;
import java.text.MessageFormat;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    private User user;
//
//    private UserGroup userGroup;
//
//    @Before
//    public void setUp() throws Exception {
//        user = new User("adle", "abc@abc.com", "test");
//
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.delete("/user/all"));
//        mvc.perform(MockMvcRequestBuilders.delete("/usergroup/all"));
//    }
//
//    @Test
//    public void addUser() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.post("/user/add")
//                .param("login", user.getLogin())
//                .param("email", user.getEmail())
//                .param("passwd", user.getPasswd())
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void addUserDuplicate() throws Exception {
//        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/user/add")
//                .param("login", user.getLogin())
//                .param("email", user.getEmail())
//                .param("passwd", user.getPasswd())
//                .accept(MediaType.APPLICATION_JSON);
//
//        mvc.perform(request);
//    }
//
//    @Test
//    public void addUserMissingData() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.post("/user/add")
//                .param("login", user.getLogin())
//                .param("passwd", user.getPasswd())
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    @Transactional
//    public void getUser() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/user/adle")
//                .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void addUserToUserGroup() throws Exception {
//        UserGroup ug = new UserGroup("ugTest");
//
//        mvc.perform(MockMvcRequestBuilders.post("/user/add")
//                .param("login", user.getLogin())
//                .param("email", user.getEmail())
//                .param("passwd", user.getPasswd())
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//
//        mvc.perform(MockMvcRequestBuilders.post("/usergroup/add")
//                .param("name", ug.getName())
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//
//        mvc.perform(MockMvcRequestBuilders.post(MessageFormat.format("/usergroup/{0}/add/{1}", ug.getName(), user.getLogin()))
//                .param("name", ug.getName())
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//

}