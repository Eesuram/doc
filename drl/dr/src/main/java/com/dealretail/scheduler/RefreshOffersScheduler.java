package com.dealretail.scheduler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.dealretail.helper.ProductHelper;

@Component
public class RefreshOffersScheduler {

	Log log = LogFactory.getLog(RefreshOffersScheduler.class);

	@Autowired
	private ProductHelper productHelper;

	//@Scheduled(cron = "0 17 16 * * ?")
	public void refreshOffers() {
		log.info("START :: Refreshing the offers");

		productHelper.refreshProducts();

		log.info("END :: Refreshed the offers");
	}

}
