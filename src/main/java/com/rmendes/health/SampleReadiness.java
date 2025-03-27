package com.rmendes.health;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import jakarta.enterprise.context.ApplicationScoped;

@Readiness
@ApplicationScoped
public class SampleReadiness implements HealthCheck{
	
	@ConfigProperty(name = "readiness.status")
	String status;
	
	@Override
	public HealthCheckResponse call() {
		if(status.equalsIgnoreCase("down")) {
		return HealthCheckResponse.down("Readiness Down");
		} else {
			return HealthCheckResponse.up("Readiness UP");
		}
	}

}
