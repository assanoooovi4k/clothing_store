package by.bntu.fitr.povt.assanoooovi4k.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MainControllerTest {
    @Mock
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void greeting() throws Exception {
        mockMvc.perform(get("/anon/tokenValidation").param("token", "Sw6HKsd5hjaD0sflFsaFasW57Gda1"))
                .andExpect(content().json("{\"error\":\"no such token\"}"));
    }

    @org.junit.Test
    public void main() {
    }

    @org.junit.Test
    public void add() {
    }

    @org.junit.Test
    public void filter() {
    }
}