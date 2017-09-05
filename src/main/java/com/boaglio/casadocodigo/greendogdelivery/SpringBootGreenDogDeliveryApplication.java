package com.boaglio.casadocodigo.greendogdelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * A anotação EnableEurekaClient define esse sistema como um candidato para
 * registrar o Eureka Server, e o ComponentScan reduz a busca dos beans da
 * aplicação toda para apenas a package com.boaglio
 * 
 * @author vagner
 *
 */
@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages = "com.boaglio")
public class SpringBootGreenDogDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGreenDogDeliveryApplication.class, args);
	}
}
