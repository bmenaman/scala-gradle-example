package com.miretz

import io.vertx.core.Vertx
import io.vertx.lang.scala.ScalaVerticle

class MyVerticle extends ScalaVerticle {

  inline val PORT = 8080

  def greeting(): String = "The server is alive."

  override def start(): Unit = {
    vertx
      .createHttpServer()
      .requestHandler(
        _.response()
          .putHeader("content-type", "text/plain")
          .end(greeting())
      )
      .listen(PORT)

  }
}
