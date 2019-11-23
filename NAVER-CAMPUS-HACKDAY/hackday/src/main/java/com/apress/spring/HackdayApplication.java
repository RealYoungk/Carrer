package com.apress.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.apress.spring.domain.Place;
import com.apress.spring.domain.User;
import com.apress.spring.repository.UserRepository;

@SpringBootApplication
public class HackdayApplication {
	private static final Logger log = LoggerFactory.getLogger(HackdayApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(HackdayApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(UserRepository repo) {
		return args -> {
			log.info("> 기존 데이터 삭제...");
			repo.deleteAll();
			
			log.info("> 데이터를 새로 생성...");
			Place place = new Place(1,"네이버 그린팩토리",0,0,"01/01/2019");
			repo.save(new User("realyoungk", place));
			
			log.info("> 전체 데이터 조회...");
			repo.findAll().forEach(entry->log.info(entry.toString()));
			
			log.info("> LIKE로 데이터 조회...");
			repo.findByUserIdLike("Cloud").forEach(entry -> log.info(entry.toString()));
		};
	}
}
