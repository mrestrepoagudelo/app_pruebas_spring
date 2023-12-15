package com.ceiba.biblioteca.prestamo.infraestruture;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.nio.file.Files;

import javax.servlet.ServletContext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ceiba.biblioteca.prestamo.infraestructure.adapter.respository.IPrestamoJpaRepository;

@SpringBootTest
@SqlGroup({
	@Sql(value = "classpath:sql_test/reset.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD),
	@Sql(value = "classpath:sql_test/prestamo-data.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
})
class PrestamoContollerTest {
	
	private static String URL_BASE = "/prestamo";

	@Autowired
	private WebApplicationContext webApplicationContext;
	
    MockMvc mockMvc;
    
    @Autowired
    private IPrestamoJpaRepository prestamoJpaRepository;
    
    @BeforeEach
	void setUp() {
    	mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
    
    @Test
    public void testVerifyWebApplicationContext() {
    	ServletContext servletContext = webApplicationContext.getServletContext();
        assertNotNull(servletContext);
        assertTrue(servletContext instanceof MockServletContext);
    }
    
    @Test
    void findAllEstatusOk() throws Exception {
    	String URL_API = URL_BASE + "/findAll";
        mockMvc.perform(get(URL_API))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(5)))
                .andExpect(jsonPath("$.[0].idPrestamo").value(1))
                .andExpect(jsonPath("$.[1].idPrestamo").value(2))
                .andExpect(jsonPath("$.[2].idPrestamo").value(3))
                .andExpect(jsonPath("$.[3].idPrestamo").value(4))
                .andExpect(jsonPath("$.[4].idPrestamo").value(5));
    }
    
    @Test
    void findAllEstatusBadRequest() throws Exception {
    	String URL_API = URL_BASE + "/";
        mockMvc.perform(get(URL_API))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
    
    @Test
    void findByIdEstatusOk() throws Exception {
    	String URL_API = URL_BASE + "/findById/{id}";
        this.mockMvc.perform(get(URL_API, 3))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.idPrestamo").value(3))
                .andExpect(jsonPath("$.idUsuraio").value(4))
                .andExpect(jsonPath("$.idLibro").value(4));
    }

    @Test
    void createEstatusOk() throws Exception {
        final File jsonFile = new ClassPathResource("sql_test/prestamo.json").getFile();
        final String userToCreate = Files.readString(jsonFile.toPath());
    	String URL_API = URL_BASE + "/create";

        this.mockMvc.perform(post(URL_API)
                        .contentType(APPLICATION_JSON)
                        .content(userToCreate))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isMap());

        assertThat(prestamoJpaRepository.findAll()).hasSize(6);
    }
    
    @Test
    void deleteByIdEstatusOk() throws Exception {
    	String URL_API = URL_BASE + "/delete/{id}";
        this.mockMvc.perform(delete(URL_API, 2))
                .andDo(print())
                .andExpect(status().isOk());

        assertThat(prestamoJpaRepository.findAll()).hasSize(4);
    }
}

