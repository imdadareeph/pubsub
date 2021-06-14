package com.app.pubsub;

import com.app.pubsub.model.TradeDetails;
import com.app.pubsub.service.TradeDetailsService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class PubsubApplication {

	@Autowired
	private TradeDetailsService tradeDetailsService;

	public static void main(String[] args) {
		SpringApplication.run(PubsubApplication.class, args);
	}

	@Data
	@NoArgsConstructor
	static class DeveloperSession{
		private String title,region,utcstarttime,utcendtime;
	}

	@Bean
	public Function<TradeDetails, TradeDetails> tradeDetails(){
		return td -> {
			System.out.println("Reversing: " + td);
			TradeDetails tradeDetails= TradeDetails.builder()
					.name(td.getName())
					.description(td.getDescription())
					.amount(td.getAmount())
					.price(td.getPrice())
					.soldoutMin(td.getSoldoutMin())
					.thresholdMax(td.getThresholdMax())
					.build();
			tradeDetailsService.save(tradeDetails);
			return tradeDetails;
		};
	}

	/*@Bean
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
	}*/

}
