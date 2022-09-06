package se.pollermanagement.vertx.service.impl;

import io.vertx.jdbcclient.JDBCPool;
import se.pollermanagement.vertx.service.Users;

public class UsersImpl implements Users {
    private final JDBCPool jdbcPool;
    public UsersImpl(JDBCPool jdbcPool) {
        this.jdbcPool = jdbcPool;
    }
}
