package com.test.chaos.performance.utils

import java.text.SimpleDateFormat
import java.util.Calendar

object DateTimeUtil {

  def DATE_FORMAT_MM_DD_YYYY = "MM-dd-yyyy"
  def DATE_FORMAT_DD_MM_YYYY = "dd-MM-yyyy"
  def DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd"

  def DATE_FORMAT_MMDDYYYY = "MM/dd/yyyy"
  def DATE_FORMAT_DDMMYYYY = "dd/MM/yyyy"

  def TIME_FORMAT_12HOUR = "hh:mm aa"
  def TIME_FORMAT_24HOUR = "HH:mm"

  def DATETIME_FORMAT_DDMMYYYY = "dd/MM/yyyy HH:mm:ss"
  def DATETIME_FORMAT_MMDDYYYY = "MM/dd/yyyy HH:mm:ss"

  def DATETIME_FORMAT_DD_MM_YYYY = "dd-MM-yyyy HH:mm:ss"
  def DATETIME_FORMAT_MM_DD_YYYY = "MM-dd-yyyy HH:mm:ss"

  def getCurrentDateTime(format: String) : String = {
    val sdf = new SimpleDateFormat(format)
    val t = sdf.format(Calendar.getInstance.getTime)
    t
  }

  def getDateTime(format: String, addDays : Int) : String = {
    val sdf = new SimpleDateFormat(format)
    val cal = Calendar.getInstance
    cal.add(Calendar.DAY_OF_MONTH, -addDays)
    val t = sdf.format(cal.getTime)
    t
  }

}
