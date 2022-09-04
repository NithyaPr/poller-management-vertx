package se.pollermanagement.vertx.service.impl;

import io.vertx.core.Handler;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.RoutingContext;
import lombok.extern.slf4j.Slf4j;
import se.pollermanagement.vertx.service.Services;

@Slf4j
public class ServicesImpl implements Services, Handler<RoutingContext> {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void addService(RoutingContext routingContext) {
        logger.info("I am in add service");
        routingContext.response()
                .putHeader("content-type", "application/json")
                .setStatusCode(200)
                .end();

    }

    @Override
    public void handle(RoutingContext event) {
        logger.info("I am in handle service");
    }
}
