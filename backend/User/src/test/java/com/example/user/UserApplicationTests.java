package com.example.user;

import com.example.user.controller.UserController;
import com.example.user.model.User;
import com.example.user.service.UserService;
import com.netflix.discovery.converters.Auto;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.util.ReflectionTestUtils;
import org.junit.jupiter.api.Assertions;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import lombok.extern.slf4j.Slf4j;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class UserApplicationTests {

    private UserService userService;
//    private User user;

    @LocalServerPort
    private int port;
    @Autowired
    private UserController userController;


    @Test
    public void contextLoads() throws Exception{
        assertThat(userController).isNotNull();
    }

    @Test
    public void shouldReturnDefaultMessage() throws Exception{
        assertThat(this.userController.test("http://localhost:" + port + String.class))
                .contains("test");
    }



    @Test
    public void shouldReturnUser() throws Exception{
        User user = new User(
                (long)1,"George","Veropoulos",
                "gv@email.com","passwordname",
                "Greek","123",26
        );
        User user2 = this.userController.saveUser(user);
        assertThat(user2);
        log.info(user2.getEmail());

    }

    @Test
    public void shouldReturnUserId() throws Exception{
        User user = new User(
                (long)1,"George","Veropoulos",
                "gv@email.com","passwordname",
                "Greek","123",26
        );
        User user2 = this.userController.findUserById((long)1);
        assertThat(user2);
        log.info(user2.getUserId().toString());
    }


//    @Test
//    void sayHello(){
//        System.out.println("Hello World");
//    }
//
//    @Test
//    void saveUserTest(){
//        userService = new UserService();
////        ReflectionTestUtils.setField(this,"userRepository");
//        user = new User(
//                (long)1,"George","Veropoulos",
//                "gv@email.com","passwordname",
//                "Greek","123",26
//        );
//
//        System.out.println(userService.saveUser(user));
//    }

//    @Autowired
//    private MockMvc mvc;
//    @Autowired
//    WebApplicationContext webApplicationContext;
//
//    @Before
//    public void setUp(){
//        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//    }
//    @Test
//    void testGetMapping() throws Exception {
//        RequestBuilder request = get("/test");
//        MvcResult result = mvc.perform(request).andReturn();
//        assertEquals("test",result.getResponse().getContentAsString());
//
////        mvc.perform((get("test")));
//    }


}
