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


class GetUserByID extends Simulation {


  val httpProtocol = http
    .baseUrl("localhost:8080/api/v1/62c40affd1c4e21112745314") // 5
    .inferHtmlResources()
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")
    .contentTypeHeader("application/json")
    .userAgentHeader("PostmanRuntime/7.26.8")

    val passUuidToCorrId = NumberUtil.passUuid //passUuidToCorrId


  val getUserByID = scenario("Get User by ID")
    .repeat(1) {
      exec(http("Get User by ID")
        .get("localhost:8080/api/v1/62c40affd1c4e21112745314") // 5
        .header("accept", "application/json")
        .header("Content-Type", "application/json")
        .check(status.is(200))
        
      )
    }

 setUp(
    getUserByID.inject(constantConcurrentUsers(RunConfigurations.NO_OF_USERS)
      .during((RunConfigurations.DURATION).seconds))
      .throttle(
      reachRps(RunConfigurations.TPS1).in((RunConfigurations.DURATION * 0.2).seconds),
      holdFor((RunConfigurations.DURATION * 0.6).seconds),
      reachRps(2).in((RunConfigurations.DURATION * 0.2).seconds)),
  ).protocols(HttpUtil.createHttpProtocolBuilder())

}