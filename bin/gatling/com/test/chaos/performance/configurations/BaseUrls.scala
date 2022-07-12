package com.test.chaos.performance.configurations

/**
* Base URL class for defining all the Base URLs of testable microservices/APIs
* 
* @author gokul.r
**/
object BaseUrls {

  val DEFAULT_TARGET_ENV = "perftest"

  def TARGET_ENV: String = {
    var env = System.getProperty("TARGET_ENV");
    if(env == null) {
      env = DEFAULT_TARGET_ENV;
    }
    println("Target ENV : " + env);
    env;
  }

  def SERVICE_HEALTH_CHECK_URI: String = {
    var healthCheckUri = "/actuator/health";
    healthCheckUri;
  }

  def SERVICE_API_DOCS_URI: String = {
    var apiDocsUri = "/v2/api-docs";
    apiDocsUri;
  }

  def getServiceBaseUrl(serviceName: String, targetEnv: String): String = {
    var baseURL = s"""https://he-internal-${serviceName}-${TARGET_ENV}.he.np.aella.tech""";
    println(s"${serviceName} Service Base URL : ${baseURL}");
    baseURL;
  }

  def KONG_URL: String = {
    var baseURL: String = null;
    if(TARGET_ENV == "local") {
      baseURL = "http://localhost:3000";
    } else {
      baseURL = s"""https://he-api-interface-${TARGET_ENV}.np.scbtechx.io""";
    }
    println("Kong Base URL : " + baseURL);
    baseURL;
  }

  def GRAPHQL_URL: String = {
    var baseURL: String = null;
    if(TARGET_ENV == "local") {
      baseURL = "http://localhost:3000";
    } else {
      baseURL = getServiceBaseUrl("api-interface", TARGET_ENV)
    }
    println("GraphQL Base URL : " + baseURL);
    baseURL;
  }

  def AUTH_SERVICE_KEYCLOAK_URL: String = {
    getServiceBaseUrl("auth-keycloak-service", TARGET_ENV);
  }

  def CMS_SERVICE_URL: String = {
    getServiceBaseUrl("cms-service", TARGET_ENV);
  }

  def CMS_SYNC_LISTENER_URL: String = {
    getServiceBaseUrl("cms-sync-listener", TARGET_ENV)
  }

  def CMS_SYNC_PUBLISHER_URL: String = {
    getServiceBaseUrl("cms-sync-publisher", TARGET_ENV)
  }

  def CONFIG_SERVICE_URL: String = {
    getServiceBaseUrl("config-service", TARGET_ENV);
  }

  def CUSTOMER_SERVICE_URL: String = {
    getServiceBaseUrl("customer-service", TARGET_ENV);
  }

  def DASHBOARD_SERVICE_URL: String = {
    getServiceBaseUrl("dashboard-service", TARGET_ENV);
  }

  def EXERCISE_SERVICE_URL: String = {
    getServiceBaseUrl("exercise-service", TARGET_ENV);
  }

  def FOOD_SERVICE_URL: String = {
    getServiceBaseUrl("food-service", TARGET_ENV);
  }

  def HEALTH_INFO_SERVICE_URL: String = {
    getServiceBaseUrl("health-info-service", TARGET_ENV);
  }

  def NOTIFICATION_SERVICE_URL: String = {
    var baseURL = s"""https://health-eco-internal-notification-service-${TARGET_ENV}.he.np.aella.tech""";
    println("Notification Service Base URL : " + baseURL);
    baseURL;
  }

  def NUTRITION_SERVICE_URL: String = {
    getServiceBaseUrl("nutrition-service", TARGET_ENV);
  }

  def PAYMENT_SERVICE_URL: String = {
    getServiceBaseUrl("payment-service", TARGET_ENV);
  }

  def REWARD_SERVICE_URL: String = {
    getServiceBaseUrl("reward-service", TARGET_ENV);
  }

  def SEARCH_SERVICE_URL: String = {
    getServiceBaseUrl("search-service", TARGET_ENV);
  }

  def SUBSCRIPTION_SERVICE_URL: String = {
    getServiceBaseUrl("subscription-service", TARGET_ENV);
  }

  def ENCRYPTION_SERVICE_URL: String = {
    getServiceBaseUrl("encryption-service", TARGET_ENV);
  }

}
