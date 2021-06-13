package com.app.pubsub;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class PubsubApplication {

	public static void main(String[] args) {
		SpringApplication.run(PubsubApplication.class, args);
	}

	@Data
	@NoArgsConstructor
	static class DeveloperSession{
		private String title,region,utcstarttime,utcendtime;
	}

	@Bean
	public Function<DeveloperSession, DeveloperSession> uppercase(){
		return ds -> {
			System.out.println("Reversing: " + ds);
			DeveloperSession uppercasedSession= new DeveloperSession();
			uppercasedSession.setRegion(ds.getRegion());
			uppercasedSession.setTitle(ds.getTitle());
			uppercasedSession.setUtcstarttime(ds.getUtcstarttime());
			uppercasedSession.setUtcendtime(ds.getUtcendtime());
			return uppercasedSession;
		};
	}

}
