package com.test.chaos.performance.simulations

import com.test.chaos.performance.configurations.RunConfigurations
import com.test.chaos.performance.http.request.builders._
import com.test.chaos.performance.utils.{HttpUtil, NumberUtil}
import io.gatling.core.Predef._
import io.gatling.core.body.Body
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import io.gatling.http.request.builder.HttpRequestBuilder
import scala.concurrent.duration._


class CreateUser extends Simulation {


  val httpProtocol = http
    .baseUrl("localhost:8080/api/v1/users") // 5
    .inferHtmlResources()
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")
    .contentTypeHeader("application/json")
    .userAgentHeader("PostmanRuntime/7.26.8")

    val passUuidToCorrId = NumberUtil.passUuid //passUuidToCorrId


  val createUser = scenario("Create User")
    .repeat(1) {
      exec(http("Create User")
        .post("localhost:8080/api/v1/users") // 5
        .header("accept", "application/json")
        .header("Content-Type", "application/json")
        .body(StringBody("""
                           {
                            "name": "rantidev singh2",
                            "username": "ransingh7",
                            "email": "ransingh7@publicisgroupe.net"
                            }
                         """)).asJson
        .check(status.is(200))
        
      )
    }

 setUp(
    createUser.inject(constantConcurrentUsers(RunConfigurations.NO_OF_USERS)
      .during((RunConfigurations.DURATION).seconds))
      .throttle(
      reachRps(RunConfigurations.TPS1).in((RunConfigurations.DURATION * 0.2).seconds),
      holdFor((RunConfigurations.DURATION * 0.6).seconds),
      reachRps(2).in((RunConfigurations.DURATION * 0.2).seconds)),
  ).protocols(HttpUtil.createHttpProtocolBuilder())

}