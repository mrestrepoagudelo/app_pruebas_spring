package com.coop.application.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {ModularHexagonalArchitectureMavenApp})
//@ContextConfiguration
class PersonaContollerTest {
	
//	private final static String URL_API = "/persona";

	@Autowired
	private WebApplicationContext webApplicationContext;
	
    MockMvc mockMvc;
    
    @Test
    void contextLoads() {
    }

    @BeforeEach
	void setUp() {
    	mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
    
//    @Test
//    public void verifyWebApplicationContextTest() {
//    	ServletContext servletContext = webApplicationContext.getServletContext();
//        assertNotNull(servletContext);
//        assertTrue(servletContext instanceof MockServletContext);
//    }
    
	@Test
	public void findAll() throws Exception {
//		String URL_FIND_ALL = "/findAlls";
//		MvcResult mvcResult = mockMvc
//				.perform(MockMvcRequestBuilders.get(URL_API + URL_FIND_ALL).accept(MediaType.APPLICATION_JSON))
//				.andReturn();
//
//		assertEquals(200, mvcResult.getResponse().getStatus());
	}
    
//    @Test
//	public void createUserTest() throws Exception {
//		String payload = "	{\n"
//				+ "		\n"
//				+ "		\"userName\":\"tms@user.com\",\n"
//				+ "		\"firstName\":\"test\",\n"
//				+ "		\"lastName\":\"test\",\n"
//				+ "		\"password\":\"password\",\n"
//				+ "		\"roles\":[{\n"
//				+ "			\n"
//				+ "			\"name\":\"ROLE_ADMIN\",\n"
//				+ "			\"description\":\"admin\"\n"
//				+ "		}]\n"
//				+ "	}";
//		
//		mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON).content(payload))
//		.andExpect(status().isOk())
//		.andReturn();
//		
//	}
//	
//	@Test
//	public void fetchUserTest() throws Exception {
//		mockMvc.perform(get("/user/{id}",1L)).andExpect(status().isOk()).andReturn();
//	}
}
