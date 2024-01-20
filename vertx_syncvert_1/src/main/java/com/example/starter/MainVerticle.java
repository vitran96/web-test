package com.example.starter;

import co.paralleluniverse.fibers.Suspendable;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Launcher;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.sync.Sync;
import io.vertx.ext.sync.SyncVerticle;

/**
 * To make Sync vertx work
 * <ol>
 *   <li>extends SyncVerticle</li>
 *   <li>use Sync.fiberHandler specially when working with Sync.await...</li>
 *   <li>remember to add @Suspendable although I am not sure what it is for yet</li>
 * </ol>
 */
public class MainVerticle extends SyncVerticle {

  public static void main(String[] args) {
    Launcher.executeCommand("run", MainVerticle.class.getName());
  }

  @Override
  @Suspendable
  public void start() throws Exception {
    try {
      HttpServer httpServer = vertx.createHttpServer()
        .requestHandler(
          Sync.fiberHandler(this::testMethod)
//          this::testMethod
//          Sync.fiberHandler(req -> {
//            req.response()
//              .putHeader("content-type", "text/plain")
//              .end("Hello from Vert.x!");
//          })
//          Sync.fiberHandler(req -> {
//            String threadName = Thread.currentThread().getName();
////            String result = Sync.awaitResult(h -> asyncMethod(threadName, h));
//            String result = Sync.awaitResult(h -> {
//              vertx.runOnContext(v -> {
//                h.handle(io.vertx.core.Future.succeededFuture("Vertx Hello from thread: " + threadName));
//              });
//            });
//
//            req.response()
//              .putHeader("content-type", "text/plain")
//              .putHeader("content-length", String.valueOf(result.length()))
//              .end(result);
////              .end("Hello from Vert.x!");
//          })
        );

      String temp = Sync.awaitResult(h -> asyncMethod("aaaaa", h));
      System.out.println("temp: " + temp);

      System.out.println("Waiting for server to start...");
//      HttpServer server = Sync.awaitResult(h -> startServer(httpServer, h));
//      HttpServer server = Sync.awaitResult(h -> {
//        httpServer.listen(8080, Sync.fiberHandler(h));
//      });
      HttpServer server = Sync.awaitResult(h -> {
        httpServer.listen(8080, s -> {
          if (s.succeeded()) {
            h.handle(Future.succeededFuture(s.result()));
          } else {
            h.handle(Future.failedFuture(s.cause()));
          }
        });
      });

      System.out.println("HTTP server started on port " + server.actualPort());

//      httpServer.listen(8080, h -> {
//        System.out.println("HTTP server started on port " + httpServer.actualPort());
//      });

//      startPromise.complete();
    } catch (Exception e) {
      System.out.println("Failed to start server");
      e.printStackTrace();
//      startPromise.fail(e);
    }
  }

  @Suspendable
  private void asyncMethod(String threadName, Handler<AsyncResult<String>> h) {
    vertx.runOnContext(v -> {
      System.out.println("Running on context");
      h.handle(io.vertx.core.Future.succeededFuture("Vertx Hello from thread: " + threadName));
    });
  }

  //  @Suspendable
  private void startServer(HttpServer httpServer, Handler<AsyncResult<HttpServer>> h) {
    httpServer.listen(8080)
      .onSuccess(server -> h.handle(io.vertx.core.Future.succeededFuture(server)))
      .onFailure(err -> h.handle(io.vertx.core.Future.failedFuture(err)));
  }

  @Suspendable
  private Future<HttpServer> startServer2(HttpServer httpServer) {
    return httpServer.listen(8080);
  }

  @Suspendable
  private void testMethod(HttpServerRequest req) {

    try {
      String threadName = Thread.currentThread().getName();
//            String result = Sync.awaitResult(h -> asyncMethod(threadName, h));
      String result = Sync.awaitResult(h -> {
        asyncMethod(threadName, h);
      });

      req.response()
        .putHeader("content-type", "text/plain")
        .putHeader("content-length", String.valueOf(result.length()))
        .end(result);
//              .end("Hello from Vert.x!");
    } catch (Exception e) {
      e.printStackTrace();
      req.response().setStatusCode(500).end("ERROR");
    }
  }
}
