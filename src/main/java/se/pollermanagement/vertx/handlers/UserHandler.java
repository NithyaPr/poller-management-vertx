package se.pollermanagement.vertx.handlers;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;
import se.pollermanagement.vertx.service.Users;

public class UserHandler implements Handler<RoutingContext> {
    private final Users users ;
    public UserHandler(Users users) {
        this.users = users;
    }

    @Override
    public void handle(RoutingContext event) {
        
    }

    public void addUser(RoutingContext routingContext) {
    }

    public void getUser(RoutingContext routingContext) {
    }

    public void getUsers(RoutingContext routingContext) {
    }

    public void deleteUser(RoutingContext routingContext) {
    }

    public void updateUser(RoutingContext routingContext) {
    }
}
