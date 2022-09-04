package se.pollermanagement.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;
import lombok.extern.slf4j.Slf4j;
import se.pollermanagement.vertx.service.Services;
import se.pollermanagement.vertx.service.impl.ServicesImpl;

@Slf4j
public class ServiceVerticle  extends AbstractVerticle {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void start() {
        logger.info("I am here");

        Router router = Router.router(vertx);
        router.post("/api/service").handler(new ServicesImpl()::addService);

        vertx.createHttpServer()
                .requestHandler(router)
                .listen(config().getInteger("http.port",9090), result -> {
                    if(result.succeeded()){
                        logger.info("SUCCESS");
                    }else {
                        logger.info("ERROR");
                    }
                });

    }

    @Override
    public void stop() {
        logger.info("Shutting down application");
    }
}
