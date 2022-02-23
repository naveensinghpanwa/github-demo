package com.naveen.githubdemo;

import com.naveen.githubdemo.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AppConfig.class)
public class GithubDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GithubDemoApplication.class, args);
	}

}
