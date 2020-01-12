package com.example.helloworld.config;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.helloworld.controller.HelloController;

@Configuration
public class KieSessionConfig {

	private final static Logger logger = LoggerFactory.getLogger(KieSessionConfig.class);
	
    @Bean
    public KieSession getSession() {
        KieServices kieService = KieServices.Factory.get();
        KieContainer kContainer = kieService.getKieClasspathContainer();
        KieSession kieSession = kContainer.newKieSession("ksession-rules");
        kieSession.setGlobal("logger", logger);
        return kieSession;
    }
}