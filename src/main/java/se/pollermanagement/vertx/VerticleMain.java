package se.pollermanagement.vertx;

import io.vertx.core.Vertx;

public class VerticleMain {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new PollerManagementVerticle());
    }

}
