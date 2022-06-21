package com.sharonsyra

import akka.http.scaladsl.model.HttpRequest
import io.circe.Json
import io.circe.generic.auto._
import io.circe.syntax._

object EchoListener {

  final case class RequestInfo(
    requestPath: String,
    headers: Seq[String],
    cookies: Seq[String],
    requestingIP: String
  )

  private[sharonsyra] def echoListener(request: HttpRequest): Json = {
    RequestInfo(
      requestPath = request.uri.toString(),
      headers = request.headers.map(httpHeader => s"${httpHeader.name()}: ${httpHeader.value()}"),
      cookies = request.cookies.map(httpCookiePair => s"${httpCookiePair.name}=${httpCookiePair.value}"),
      requestingIP = request.uri.authority.host.toString()
    ).asJson
  }
}
