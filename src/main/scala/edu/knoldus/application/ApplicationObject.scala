package edu.knoldus.application

import edu.knoldus.operation.classes.Item
import edu.knoldus.operation.service.InventoryService
import org.apache.log4j.Logger

import scala.io.StdIn._

object ApplicationObject extends App {
  val logger = Logger.getLogger(this.getClass)
  val initialMap: Map[Int, Item] = Map.empty
  def runApplication(map: Map[Int, Item], flag: Boolean): Boolean = {
    if(flag){
      val inventoryObject = InventoryService(map)
      logger.info("Hi there! welcome to KnolKart\n")
      logger.info("\nPress 1 to add element\n")
      logger.info("\nPress 2 to update an item count\n")
      logger.info("\nPress 3 to exit application\n")
      logger.info("\n")
      val choice = readInt()
      choice match {
        case 1 => runApplication(inventoryObject.addItem, true)
        case 2 => runApplication(inventoryObject.updateCount, true)
        case 3 => logger.info(s"$map\n")
          runApplication(map, false)
      }
    } else {
      false
    }
  }

  runApplication(initialMap, true)


}
