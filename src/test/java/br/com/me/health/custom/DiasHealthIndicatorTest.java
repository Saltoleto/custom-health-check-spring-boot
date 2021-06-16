package br.com.me.health.custom;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * @author Fernando Saltoleto
 */
@SpringBootTest
@AutoConfigureMockMvc
class DiasHealthIndicatorTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void health() throws Exception {
        mockMvc.perform(get("/actuator/health/dias"))
                .andExpect(jsonPath("$.status").exists())
                .andExpect(jsonPath("$.details").exists());
    }

}