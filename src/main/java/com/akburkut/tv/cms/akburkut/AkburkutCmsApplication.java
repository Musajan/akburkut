package com.akburkut.tv.cms.akburkut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
// 开启缓存
@EnableCaching
public class AkburkutCmsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AkburkutCmsApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	    return builder.sources(AkburkutCmsApplication.class);
    }
}
