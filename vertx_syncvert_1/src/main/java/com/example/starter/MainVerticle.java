package com.example.starter;

import co.paralleluniverse.fibers.Suspendable;
import io.vertx.core.Launcher;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.sync.Sync;
import io.vertx.ext.sync.SyncVerticle;

public class MainVerticle extends SyncVerticle {

  public static void main(String[] args) {
    Launcher.executeCommand("run", MainVerticle.class.getName());
  }

  @Suspendable
  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    try {
      HttpServer httpServer = vertx.createHttpServer().requestHandler(req -> {
        req.response()
          .putHeader("content-type", "text/plain")
          .end("Hello from Vert.x!");
      });

      System.out.println("Waiting for server to start...");
      HttpServer server = Sync.awaitResult(h -> httpServer.listen(8888, h));

      System.out.println("HTTP server started on port " + server.actualPort());

//      startPromise.complete();
    } catch (Exception e) {
      System.out.println("Failed to start server");
//      e.printStackTrace();
      startPromise.fail(e);
    }
  }
}
