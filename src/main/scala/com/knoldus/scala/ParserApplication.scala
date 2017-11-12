package com.knoldus.scala

import java.io.FileInputStream

import com.knoldus.scala.parser.Parser

object ParserApplication extends App{
  val parser = new Parser
  private val xmlPath = "src/main/resources/cpd.xml"
  private val xmlInputStream = new FileInputStream(xmlPath)
  private val xsdPath = "src/main/resources/cpd.xsd"
  if (parser.validateXML(xmlInputStream, xsdPath)) {
    println("successfully validated")
  } else {
    println("invalid file")
  }
}
