package se.pollermanagement.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.ext.web.Router;
import io.vertx.jdbcclient.JDBCConnectOptions;
import io.vertx.jdbcclient.JDBCPool;
import io.vertx.sqlclient.PoolOptions;
import io.vertx.sqlclient.Row;
import io.vertx.sqlclient.SqlConnection;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.Configuration;
import se.pollermanagement.vertx.configuration.Config;
import se.pollermanagement.vertx.handlers.ServiceHandler;
import se.pollermanagement.vertx.handlers.UserHandler;
import se.pollermanagement.vertx.service.Services;
import se.pollermanagement.vertx.service.Users;
import se.pollermanagement.vertx.service.impl.ServicesImpl;
import se.pollermanagement.vertx.service.impl.UsersImpl;

@Slf4j
public class PollerManagementVerticle extends AbstractVerticle {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void start() {
        logger.info("Vertx starting..");
        Config config = new Config("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false",
                "databaseUser", "databasePassword");

        flywayMigrator(config);

        JDBCPool pool = getJdbcPool(config);

        Router router = Router.router(vertx);
        setUpRoutes(pool, router);

        createHttpServerListener(router);
        logger.info("Vertx started and configured routes..");

    }

    private void createHttpServerListener(Router router) {
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

    private void setUpRoutes(JDBCPool pool, Router router) {
        Services services = new ServicesImpl(pool);

        router.post("/api/service").handler(new ServiceHandler(services)::addService);
        router.get("/api/service/{serviceId}").handler(new ServiceHandler(services)::getService);
        router.get("/api/service/list").handler(new ServiceHandler(services)::getServices);
        router.delete("/api/service/{serviceId}").handler(new ServiceHandler(services)::deleteService);
        router.put("/api/service/{serviceId}").handler(new ServiceHandler(services)::updateService);

        Users users = new UsersImpl(pool);

        router.post("/api/user").handler(new UserHandler(users)::addUser);
        router.get("/api/user/{userId}").handler(new UserHandler(users)::getUser);
        router.get("/api/user/list").handler(new UserHandler(users)::getUsers);
        router.delete("/api/user/{userId}").handler(new UserHandler(users)::deleteUser);
        router.put("/api/user/{userId}").handler(new UserHandler(users)::updateUser);
    }

    private JDBCPool getJdbcPool(Config config) {
        JDBCPool pool = JDBCPool.pool(
                vertx,
                // configure the connection
                new JDBCConnectOptions()
                        .setJdbcUrl(config.getUrl())
                        .setUser(config.getUserName())
                        .setPassword(config.getPassword()),
                // configure the pool
                new PoolOptions()
                        .setMaxSize(6)
        );
        return pool;
    }

    private void flywayMigrator(Config config) {
        Flyway flyway = Flyway.configure().dataSource(
                config.getUrl(),
                config.getUserName(),config.getPassword())

                .load();
            flyway.migrate();
    }

    @Override
    public void stop() {
        logger.info("Shutting down application");
    }
}
