package com.test.chaos.performance.configurations

/**
* Configuration class for defining all the parameters used while executing a test run.
* 
* @author gokul.r
**/
object RunConfigurations {

  def INPUT_USERS: String = {
    var inputUsers = System.getProperty("INPUT_USERS");
    if (inputUsers == null) {
      inputUsers = "users.csv";
    }
    println("Input Users : " + inputUsers);
    inputUsers;
  }

  def NO_OF_USERS: Int = {
    var noOfUsers = System.getProperty("NO_OF_USERS");
    if (noOfUsers == null) {
      noOfUsers = "10";
    }
    println("Total Users : " + noOfUsers);
    noOfUsers.toInt;
  }

  def RAMP_UP_TIME: Int = {
    var rampUpTime = System.getProperty("RAMP_UP_TIME");
    if (rampUpTime == null) {
      rampUpTime = "1";
    }
    println("RAMP UP TIME : " + rampUpTime);
    rampUpTime.toInt;
  }

  def THINK_TIME: Int = {
    var thinkTime = System.getProperty("THINK_TIME");
    if (thinkTime == null) {
      thinkTime = "1";
    }
    println("THINK TIME : " + thinkTime);
    thinkTime.toInt;
  }

  def DURATION: Int = {
    var duration = System.getProperty("DURATION");
    if (duration == null) {
      duration = "1";
    }
    println("Duration : " + duration);
    duration.toInt;
  }

  def ITERATIONS: Int = {
    var iterations = System.getProperty("ITERATIONS");
    if (iterations == null) {
      iterations = "1";
    }
    println("ITERATIONS : " + iterations);
    iterations.toInt;
  }

  def TPS_USERS: Int = {
    var tpsUsers = System.getProperty("TPS_USERS");
    if (tpsUsers == null) {
      tpsUsers = "1";
    }
    println("TPS Users : " + tpsUsers);
    tpsUsers.toInt;
  }

  def TPS0: Int = {
    var tps = System.getProperty("TPS0");
    if (tps == null) {
      tps = "1";
    }
    println("TPS0 : " + tps);
    tps.toInt;
  }

  def TPS1: Int = {
    var tps = System.getProperty("TPS1");
    if (tps == null) {
      tps = "1";
    }
    println("TPS1 : " + tps);
    tps.toInt;
  }

  def TPS2: Int = {
    var tps = System.getProperty("TPS2");
    if (tps == null) {
      tps = "1";
    }
    println("TPS2 : " + tps);
    tps.toInt;
  }

  def TPS3: Int = {
    var tps = System.getProperty("TPS3");
    if (tps == null) {
      tps = "1";
    }
    println("TPS3 : " + tps);
    tps.toInt;
  }

  def TPS4: Int = {
    var tps = System.getProperty("TPS4");
    if (tps == null) {
      tps = "1";
    }
    println("TPS4 : " + tps);
    tps.toInt;
  }

  def TPS5: Int = {
    var tps = System.getProperty("TPS5");
    if (tps == null) {
      tps = "1";
    }
    println("TPS5 : " + tps);
    tps.toInt;
  }

  def TPS6: Int = {
    var tps = System.getProperty("TPS6");
    if (tps == null) {
      tps = "1";
    }
    println("TPS6 : " + tps);
    tps.toInt;
  }

  def TPS7: Int = {
    var tps = System.getProperty("TPS7");
    if (tps == null) {
      tps = "1";
    }
    println("TPS7 : " + tps);
    tps.toInt;
  }

  def TPS8: Int = {
    var tps = System.getProperty("TPS8");
    if (tps == null) {
      tps = "1";
    }
    println("TPS8 : " + tps);
    tps.toInt;
  }

  def TPS9: Int = {
    var tps = System.getProperty("TPS9");
    if (tps == null) {
      tps = "1";
    }
    println("TPS9 : " + tps);
    tps.toInt;
  }

}