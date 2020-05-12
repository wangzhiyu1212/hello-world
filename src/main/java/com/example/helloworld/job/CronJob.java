package com.example.helloworld.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.helloworld.controller.HelloController;

@Component
public class CronJob {
	private final static Logger logger = LoggerFactory.getLogger(HelloController.class);

//	@Scheduled(cron = "0 0/1 * * * ?")
	public void cronJob() throws InterruptedException {

		logger.info("cronJob start");

	}
}
