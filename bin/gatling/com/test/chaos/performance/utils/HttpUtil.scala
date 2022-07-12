package com.test.chaos.performance.utils

import com.test.chaos.performance.configurations.BaseUrls
import io.gatling.core.body.Body
import io.gatling.http.Predef._
import io.gatling.core.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import io.gatling.http.request.builder.HttpRequestBuilder

/**
 * HttpUtil class for defining all utility functions related to io.gatling.http
 *
 * @author gokul.raja
 * */
object HttpUtil {

  def createHttpProtocolBuilder(baseUrl: String = BaseUrls.GRAPHQL_URL) : HttpProtocolBuilder = {
    http
      .baseUrl(baseUrl)
      .inferHtmlResources()
      .acceptHeader("*/*")
      .acceptEncodingHeader("gzip, deflate")
      .contentTypeHeader("application/json")
      .header("Accept-Language", "EN")
      .userAgentHeader("PostmanRuntime/7.26.8")
  }

  def createRawHttpGetRequestBuilder(requestName: String, url: String) : HttpRequestBuilder = {
    http(requestName)
      .get(url)
      .check(status.in(200))
  }

  def createBasicHttpPostRequestBuilder(requestName: String, url: String, body: Body) : HttpRequestBuilder = {
    http(requestName)
      .post(url)
      .header("Content-Type", "application/json")
      .body(body)
      .check(status.in(200))
  }

  def createBasicHttpPutRequestBuilder(requestName: String, url: String, body: Body) : HttpRequestBuilder = {
    http(requestName)
      .put(url)
      .header("Content-Type", "application/json")
      .body(body)
      .check(status.in(200))
  }

  def createBasicHttpGetRequestBuilder(requestName: String, url: String) : HttpRequestBuilder = {
    http(requestName)
      .get(url)
      .header("Content-Type", "application/json")
      .check(status.in(200))
  }

  def createAuthorisedHttpPostRequestBuilder(requestName: String, url: String, body: Body) : HttpRequestBuilder = {
    http(requestName)
      .post(url)
      .header("Content-Type", "application/json")
      .header("Authorization", "Bearer ${accessToken}")
      .header("idToken", "${idToken}")
      .body(body)
      .check(status.in(200))
  }

  def createAuthorisedHttpPostRequestBuilder(requestName: String, url: String, body: Body, expectedStatus: Int) : HttpRequestBuilder = {
    http(requestName)
      .post(url)
      .header("Content-Type", "application/json")
      .header("Authorization", "Bearer ${accessToken}")
      .header("idToken", "${idToken}")
      .body(body)
      .check(status.in(expectedStatus))
  }

  def createAuthorisedHttpPutRequestBuilder(requestName: String, url: String, body: Body) : HttpRequestBuilder = {
    http(requestName)
      .put(url)
      .header("Content-Type", "application/json")
      .header("Authorization", "Bearer ${accessToken}")
      .header("idToken", "${idToken}")
      .body(body)
      .check(status.in(200))
  }

  def createAuthorisedHttpGetRequestBuilder(requestName: String, url: String) : HttpRequestBuilder = {
    http(requestName)
      .get(url)
      .header("Content-Type", "application/json")
      .header("Authorization", "Bearer ${accessToken}")
      .header("idToken", "${idToken}")
      .check(status.in(200))
  }

}