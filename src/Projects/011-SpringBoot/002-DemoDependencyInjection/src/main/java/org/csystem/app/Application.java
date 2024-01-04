package org.csystem.app;

import com.karandev.util.spring.datetime.BasePackage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.csystem", BasePackage.BASE_PACKAGE})
public class Application {
	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}
}
