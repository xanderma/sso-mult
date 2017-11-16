package cn.supermartin.martin.ssomult;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
@SpringBootApplication
public class SsoMultApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsoMultApplication.class, args);
	}
}
