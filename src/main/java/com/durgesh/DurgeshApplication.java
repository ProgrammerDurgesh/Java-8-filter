package com.durgesh;

import com.durgesh.scheduler.Scheduler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DurgeshApplication {

	public static void main(String[] args) {
		SpringApplication.run(DurgeshApplication.class, args);

	}

}
