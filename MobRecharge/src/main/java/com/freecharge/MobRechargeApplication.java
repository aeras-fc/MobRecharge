package com.freecharge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages= { "com.freecharge.controllers", "com.freecharge", "com.freecharge.services", "com.freecharge.entities", "com.freecharge.repos"})

//@ComponentScan(basePackages = { "com.freecharge.controllers","com.freecharge.MobRecharge", "com.freecharge.services", "com.freecharge.entities", "com.freecharge.repos"} )
public class MobRechargeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobRechargeApplication.class, args);
	}

}
