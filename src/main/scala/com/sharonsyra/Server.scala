package com.sharonsyra

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import com.sharonsyra.Registry.appRoute

import scala.concurrent.ExecutionContextExecutor

object Server {

  def main(args: Array[String]): Unit = {

    implicit val system: ActorSystem[Nothing] = ActorSystem(Behaviors.empty, "my-system")

    implicit val executionContext: ExecutionContextExecutor = system.executionContext

    Http().newServerAt("localhost", 9532).bind(appRoute)

    println(s"Server now online. Please navigate to http://localhost:9532/echo\nPress RETURN to stop...")
  }
}
