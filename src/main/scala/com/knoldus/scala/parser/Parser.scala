package com.knoldus.scala.parser

import java.io.{File, InputStream}
import javax.xml.XMLConstants
import javax.xml.transform.sax.SAXSource
import javax.xml.validation.SchemaFactory

import org.xml.sax.InputSource

import scala.util.control.NonFatal

class Parser {

  def validateXML(xmlInputStream: InputStream, xsdPath: String) = {
    try{
      val sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
      val schema = sf.newSchema(new File(xsdPath))
      val validator = schema.newValidator()
      validator.validate(new SAXSource(new InputSource(xmlInputStream)))
      true
    }catch {
      case NonFatal(ex) =>
        ex.printStackTrace()//use logging here
        false
    }
  }

}
