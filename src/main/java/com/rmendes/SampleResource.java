package com.rmendes;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/ocp")
public class SampleResource {
	
	@ConfigProperty(name = "pod.name")
	String podName;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/podName")
    public String getPodName() {
        return "Hello from Quarkus REST";
    }
}
