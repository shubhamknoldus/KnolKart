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
      logger.info("\nPress 3 to view cart\n")
      logger.info("\nPress 4 to exit application\n")
      logger.info("\n")
      val choice = readInt()
      choice match {
        case 1 => inventoryObject.addItem
        case 2 => inventoryObject.updateCount
        case 3 =>
        case 4 => logger.info(s"$map\n") false
      }
    } else {
      false
    }
  }
  runApplication(initialMap, true)
}
