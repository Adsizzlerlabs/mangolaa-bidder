package com.adsizzler.mangolaa.bidder;


import com.adsizzler.mangolaa.bidder.verticle.MangolaaBidderVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Slf4j
public class BidderApplication {

	@Autowired
	private Vertx vertx;

	@Autowired
	private SpringVerticleFactory springVerticleFactory;


	public static void main(String[] args) {
		SpringApplication.run(BidderApplication.class, args);
	}

	@PostConstruct
	void initServer(){
		vertx.registerVerticleFactory(springVerticleFactory);
		final int cores = Runtime.getRuntime().availableProcessors();
		log.info("Number of cores available {} " , cores);
		final int numOfVerticlesToDeploy = cores * 2;
		log.info("Deploying {} verticle instances ", numOfVerticlesToDeploy);
		final DeploymentOptions options = new DeploymentOptions().setInstances(numOfVerticlesToDeploy);
		vertx.deployVerticle(springVerticleFactory.prefix() + ":" + MangolaaBidderVerticle.class.getName(),options, deployment->{
			if(deployment.succeeded()){
				log.info("Deployment successfull. Deployment Info {} " , deployment.result());
				log.info("Trying to connect with redis");
			}
			else{
				log.error("Deployment Failed with exception ", deployment.cause());
			}
		});
	}

}
