package com.knoldus.scala.parser

import java.io.FileInputStream

import org.scalatest.WordSpec

class ParserSpec extends WordSpec{

  val parser = new Parser
  val cpdXmlPath = "src/main/resources/cpd.xml"
  val cpdXsdPath = "src/main/resources/cpd.xsd"
  val shipOrderXmlPath = "src/main/resources/shiporder.xml"
  val shipOrderXsdPath = "src/main/resources/shiporder.xsd"

  "Parser" should {
    "validate cpd files successfully" in {
      val cpdInputStream = new FileInputStream(cpdXmlPath)
      val result = parser.validateXML(cpdInputStream, cpdXsdPath)
      assert(result)
    }

    "validate shipOrder files successfully" in {
      val shipOrderInputStream = new FileInputStream(shipOrderXmlPath)
      val result = parser.validateXML(shipOrderInputStream, shipOrderXsdPath)
      assert(result)
    }

    "not validate incompatible files" in {
      val cpdInputStream = new FileInputStream(cpdXmlPath)
      val result = parser.validateXML(cpdInputStream, shipOrderXsdPath)
      assert(!result)
    }
  }

}
