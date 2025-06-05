package com.rmendes;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.micrometer.core.annotation.Timed;
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
    @Timed(value="pod_name_latency")
    public String getPodName() {
        return "PodName: "+podName;
    }
}
