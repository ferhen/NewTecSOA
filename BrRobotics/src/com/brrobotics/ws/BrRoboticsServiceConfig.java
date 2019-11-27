package com.brrobotics.ws;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("rest")
public class BrRoboticsServiceConfig extends Application {

	
	@Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
     

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
    	
        resources.add(com.brrobotics.ws.BrRoboticsService.class);
        resources.add(com.brrobotics.ws.BrRoboticsServiceExceptionMapper.class);
    }
}