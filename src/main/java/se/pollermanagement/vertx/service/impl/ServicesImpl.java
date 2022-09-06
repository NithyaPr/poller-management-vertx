package se.pollermanagement.vertx.service.impl;

import io.vertx.core.Handler;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.ext.web.RoutingContext;
import io.vertx.jdbcclient.JDBCPool;
import lombok.extern.slf4j.Slf4j;
import se.pollermanagement.vertx.service.Services;

@Slf4j
public class ServicesImpl implements Services{

    Logger logger = LoggerFactory.getLogger(this.getClass());
    private JDBCPool jdbcPool;

    public ServicesImpl(JDBCPool jdbcPool) {
        this.jdbcPool = jdbcPool;
    }

    @Override
    public void addService() {

        // Develop single page app fo hotel management using typescript, react, kotlin
        // hotel has 7 rooms, 4 - single, 3 double
        // need to see overall view of hotel bookings per day, week, room
        jdbcPool.query("select * from SERVICES")
                .execute()
                .onFailure(e ->  logger.info("Failed to fetch" + e))
                .onSuccess(s -> logger.info("Successfully fetched " + s.size()));


    }

    public void handle(RoutingContext routingContext) {

    }
}
