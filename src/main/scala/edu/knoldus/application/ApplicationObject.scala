package edu.knoldus.application

import edu.knoldus.operation.classes.Item
import edu.knoldus.operation.service.InventoryService
import org.apache.log4j.Logger

import scala.io.StdIn._

object ApplicationObject extends App {
  val logger = Logger.getLogger(this.getClass)
  val initialMap: Map[Int, Item] = Map.empty

  def runApplication(map: Map[Int, Item], flag: Boolean): Boolean = {
    if (flag) {
      val inventoryObject = InventoryService(map)
      logger.info("Hi there! welcome to Knolkart\n")
      logger.info("\nPress 1 to add element\n")
      logger.info("\nPress 2 to update an item count\n")
      logger.info("\nPress 3 to view all items\n")
      logger.info("\nPress 4 to exit application\n")
      logger.info("\n")
      val choice = readInt()
      choice match {
        case x if x == 1 => inventoryObject.addItem
        case x if x == 2 => inventoryObject.updateCount
        case x if x == 3 => inventoryObject.filter
        case x if x == 4 => ApplicationObject.runApplication(map, false)
      }
    } else {
      false
    }
  }

  runApplication(initialMap, true)
}
