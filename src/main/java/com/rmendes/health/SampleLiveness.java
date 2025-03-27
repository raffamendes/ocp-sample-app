package com.rmendes.health;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import jakarta.enterprise.context.ApplicationScoped;

@Liveness
@ApplicationScoped
public class SampleLiveness implements HealthCheck{

	@ConfigProperty(name = "liveness.status")
	String status;
	
	@Override
	public HealthCheckResponse call() {
		if(status.equalsIgnoreCase("down")) {
		return HealthCheckResponse.down("Liveness Down");
		} else {
			return HealthCheckResponse.up("Liveness UP");
		}
	}

}
