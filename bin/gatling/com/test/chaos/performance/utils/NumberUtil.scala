package com.test.chaos.performance.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import scala.util.Random
import java.util.UUID

/**
* NumberUtil class for defining all utility functions related to numbers.
* 
* @author gokul.raja
**/
object NumberUtil {

  def COUNTRY_CODE_INDIA : String = "+91"

  def COUNTRY_CODE_THAILAND : String = "+66"

  def randomAlphaNumeric(length: Int): String = Random.alphanumeric.take(length).mkString

  def randomInt(length: Int): String = Random.alphanumeric.filter(_.isDigit).take(length).mkString

  def randomMobileNo : String = {
    val sdf = new SimpleDateFormat("ddHHmm")
    val mobileNo = COUNTRY_CODE_INDIA + sdf.format(Calendar.getInstance.getTime)
    mobileNo
  }

  def mobileNoPrefix : String = {
    val sdf = new SimpleDateFormat("ddHHmm")
    val mobileNo = sdf.format(Calendar.getInstance.getTime)
    mobileNo
  }

  def passUuid : String = java.util.UUID.randomUUID().toString

}
