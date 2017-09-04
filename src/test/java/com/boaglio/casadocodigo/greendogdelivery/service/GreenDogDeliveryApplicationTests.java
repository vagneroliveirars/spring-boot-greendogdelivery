package com.boaglio.casadocodigo.greendogdelivery.service;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GreenDogDeliveryApplicationTests {
	
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mvc;
	
	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testeHome() throws Exception {
		String url = "/api";
		
		System.out.println(this.mvc.perform(get(url))
				.andDo(print()));
		
		this.mvc.perform(get(url))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("clientes")));
	}
	
	@Test
	public void findItem2() throws Exception {
		String url = "/api/itens/2";
		
		System.out.println(this.mvc.perform(get(url)).andDo(print()));
		
		this.mvc.perform(get(url))
			.andExpect(status().isOk())
			.andExpect(jsonPath("preco", equalTo(25.0)));
	}
	
	@Test
	public void cadastroNovoPedido() throws Exception {
		String url = "/rest/pedido/novo/1/1,2";
		
		System.out.println(this.mvc.perform(get(url)).andDo(print()));
		
		this.mvc.perform(
				get(url))
				.andExpect(status().isOk())
				.andExpect(jsonPath("valorTotal", is(55.0)))
				.andExpect(jsonPath("pedido", greaterThan(3)))
				.andExpect(jsonPath("mensagem", equalTo("Pedido efetuado com sucesso")));
	}

}
