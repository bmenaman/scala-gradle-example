package com.miretz

import io.vertx.core.Vertx

inline val PORT = 8080

object App {
  def main(args: Array[String]): Unit = {
    println(s"Server starting on port $PORT ...")

    Vertx.vertx
      .createHttpServer()
      .requestHandler(
        _.response()
          .putHeader("content-type", "text/plain")
          .end(greeting())
      )
      .listen(PORT)
  }

  def greeting(): String = "The server is alive."
}
