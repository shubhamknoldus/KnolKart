package edu.knoldus.database

/*
import java.io.{File, PrintWriter}

import edu.knoldus.operation.classes.Item
import org.json4s.DefaultFormats
import org.json4s.native.Json

import scala.io.Source
*/

object DatabaseObject extends App/* {
  implicit val formats = DefaultFormats
  val item = Item("String" ,12345, "price deascription", "vendor", "category number", 10)
  val map1 = Map(1 -> item)
  val objectToJSONString = Json.apply(formats).write(map1)
  val writerToFile: PrintWriter = new PrintWriter(new File("/home/knoldus/Desktop/sampleDB.txt"))

  writerToFile.append(objectToJSONString+"\n")
  writerToFile.close()
 val list2 = for (line <- Source.fromFile("/home/knoldus/Desktop/sampleDB.txt").getLines()) yield Json.apply(formats).read[Map[Int, Item]](line)
  val x = list2.toList
}*/
