package com.spring.test;

import java.awt.print.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.test.bean.safe;
@RestController
@SpringBootApplication
public class LearnSptringbootApplication {
	/**
	 * 获得配置文件信息的两种形式
	 */
	
	@Value("${book.name}")
	private String title;
	@Value("${book.author}")
	private String author;
	
	/**
	 * 配置文件安全
	 */
	@Autowired safe sf;
	
	@RequestMapping("/")
	public String book(){
		return author+title;
	}
	@RequestMapping("safe")
	public String author(){
		return sf.getName()+sf.getAge();
	}
	public static void main(String[] args) {
		SpringApplication.run(LearnSptringbootApplication.class, args);
	}
}
