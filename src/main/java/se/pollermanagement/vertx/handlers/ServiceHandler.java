package se.pollermanagement.vertx.handlers;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;
import se.pollermanagement.vertx.service.Services;

public class ServiceHandler implements Handler<RoutingContext> {

    private final Services services;

    public ServiceHandler(Services services) {
        this.services = services;
    }
    
    @Override
    public void handle(RoutingContext routingContext) {
        routingContext.response()
                .putHeader("content-type", "application/json")
                .setStatusCode(200)
                .end();
    }
    
    public void addService(RoutingContext routingContext){
        services.addService();
        routingContext.response()
                .putHeader("content-type", "application/json")
                .setStatusCode(200)
                .end();
    }

    public void getService(RoutingContext routingContext) {
    }

    public void deleteService(RoutingContext routingContext) {
    }

    public void updateService(RoutingContext routingContext) {
    }

    public void getServices(RoutingContext routingContext) {
    }
}
