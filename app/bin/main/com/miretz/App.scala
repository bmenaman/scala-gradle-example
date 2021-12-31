package com.miretz

import io.vertx

object App {
  def main(args: Array[String]): Unit = {
    println("Server starting...")

    vertx
      .createHttpServer()
      .requestHandler(_.response().end("Hello World"))
      .listen(8080)

    vertx.eventBus().consumer("hello", a => println(a.body()))
  }
}
