package com.spring_study;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import com.spring_study.web.HelloController;




import java.util.concurrent.ExecutionException;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
@ContextConfiguration(classes = Application.class) //test가 안되서 넣은 코드
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void hello_is_return() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }
}
