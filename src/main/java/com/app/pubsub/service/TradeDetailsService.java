package com.app.pubsub.service;




import com.app.pubsub.model.TradeDetails;

import java.util.List;

public interface TradeDetailsService {

	TradeDetails findById(long id);

	List<TradeDetails> findAll();

	TradeDetails save(TradeDetails book);

	void delete(long id);

	TradeDetails update(TradeDetails tradeDetails);
}
