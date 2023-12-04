package com.example.starter;

import co.paralleluniverse.fibers.Suspendable;
import io.vertx.core.Launcher;
import io.vertx.core.Promise;
import io.vertx.ext.sync.SyncVerticle;

public class MainVerticle extends SyncVerticle {

  public static void main(String[] args) {
    Launcher.executeCommand("run", MainVerticle.class.getName());
  }

  @Suspendable
  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    vertx.createHttpServer().requestHandler(req -> {
      req.response()
        .putHeader("content-type", "text/plain")
        .end("Hello from Vert.x!");
    }).listen(8888, http -> {
      if (http.succeeded()) {
        startPromise.complete();
        System.out.println("HTTP server started on port 8888");
      } else {
        startPromise.fail(http.cause());
      }
    });
  }
}
