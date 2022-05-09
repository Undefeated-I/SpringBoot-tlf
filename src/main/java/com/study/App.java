package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //表示是springboot启动类
public class App {
	
    public static void main( String[] args ){
    	//启动Spring boot程序
        SpringApplication.run(App.class, args);
    }
}
 