package com.miretz

import com.miretz.MyVerticle
import io.vertx.core.Vertx
import io.vertx.core.http.HttpMethod
import io.vertx.lang.scala.ScalaVerticle

object App {

  private val vertx = Vertx.vertx()

  def main(args: Array[String]): Unit = {
    // Deploy server and test it
    vertx
      .deployVerticle(
        ScalaVerticle.nameForVerticle[MyVerticle]
      )
      .onSuccess({ h =>
        println("MyVerticle was deployed.")
        callServer()
      })
  }

  def callServer(): Unit = {
    vertx
      .createHttpClient()
      .request(
        HttpMethod.GET,
        8080,
        "127.0.0.1",
        "/"
      )
      .compose(req =>
        req
          .send()
          .compose(resp => {
            println(s"Got response status: ${resp.statusCode()}")
            resp.body()
          })
      )
      .onSuccess(body => {
        println(s"Got data: ${body.toString}")
      })
      .onFailure(e => e.printStackTrace())
  }
}
