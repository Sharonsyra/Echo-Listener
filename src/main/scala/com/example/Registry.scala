package com.example

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives.path
import akka.http.scaladsl.server.{RequestContext, Route}

object Registry {

  val appRoute: Route =
    path("echo") { ctx: RequestContext =>
      val httpRequestDetails = EchoListener.echoListener(ctx.request)
      ctx.complete(HttpEntity(ContentTypes.`application/json`, httpRequestDetails.toString()))
    }
}
