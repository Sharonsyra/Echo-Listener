package com.example

import akka.http.scaladsl.model.ContentTypes
import akka.http.scaladsl.model.headers.OAuth2BearerToken
import akka.http.scaladsl.testkit.ScalatestRouteTest
import com.example.Registry.appRoute
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class RegistryTest extends AnyWordSpec with Matchers with ScalatestRouteTest {

  "The service" should {

    "leave requests to other paths unhandled" in {
      Get("/") ~> appRoute ~> check {
        handled shouldBe false
      }
    }

    "handle requests to echo path" in {
      Get("/echo") ~> appRoute ~> check {
        handled shouldBe true
      }
    }

    "return content type json on requests to echo path" in {
      Get("/echo") ~> appRoute ~> check {
        response.entity.withContentType(ContentTypes.`application/json`)
      }
    }

    "return request details on calls to echo path" in {
      Get("/echo") ~> appRoute ~> check {
        responseAs[String] shouldBe """{
                                      |  "requestPath" : "http://example.com/echo",
                                      |  "headers" : [
                                      |  ],
                                      |  "cookies" : [
                                      |  ],
                                      |  "requestingIP" : "example.com"
                                      |}""".stripMargin

      }
    }

    "return request details on calls to echo path for requests with set headers" in {
      Get("/echo") ~> addCredentials(OAuth2BearerToken("VALID_TOKEN")) ~> appRoute ~> check {
        responseAs[String] shouldBe """{
                                      |  "requestPath" : "http://example.com/echo",
                                      |  "headers" : [
                                      |    "Authorization: Bearer VALID_TOKEN"
                                      |  ],
                                      |  "cookies" : [
                                      |  ],
                                      |  "requestingIP" : "example.com"
                                      |}""".stripMargin

      }
    }
  }
}
