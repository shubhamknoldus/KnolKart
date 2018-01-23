package edu.knoldus.operation.service

import edu.knoldus.application.ApplicationObject
import edu.knoldus.operation.classes.Item
import scala.io.StdIn._

case class InventoryService(itemMap: Map[Int, Item]) {

  val logger = ApplicationObject.logger

  def addItem: Map[Int, Item] ={

    def addItemHelper(itemList: Map[Int, Item]):Map[Int, Item]={
      logger.info("\nenter the id for the object to add\n")
      val id = readInt()
      if(itemList.contains(id)){
        logger.info("\nitem  with this id already exist please try again\n")
        val b = itemList(id)
        logger.info(b)
        logger.info(s"\n do you want to update the count of item")
        logger.info("\npress 1 to update the count else press 2")
        val choice = readInt()
        if(choice == 1)
          {
            updateCount
          } else {
          addItemHelper(itemList)
        }

      }
      logger.info("\nenter the name of Item\n")
      val name = readLine()
      logger.info("\nenter the price of the item\n")
      val price = readDouble()
      logger.info("\nenter the description of the item\n")
      val description = readLine()
      logger.info("\nenter the vendor info for the item\n")
      val vendor = readLine()
      logger.info("\nenter the category of Item\n")
      val category = readLine()
      logger.info("\nenter the number of item you want to add\n")
      val count = readInt()
      val newItem = Item(name, price, description, vendor, category, count)
      val updatedMap: Map[Int, Item] = itemMap + (id -> newItem)
      logger.info("press 1 to add more elements\npress 2 to done adding\n")
      val choice = readInt()
      if(choice == 1){
        logger.info(s"adding more elements current map is\n\n ${updatedMap}\n\n\n\n")
        addItemHelper(updatedMap)
      }else{
        updatedMap
      }
    }
    addItemHelper(itemMap)
  }

  def updateCount: Map[Int, Item] = {
    logger.info("\nenter the id of the item to update count\n")
    val id = readInt()
    if(!itemMap.contains(id)){
      logger.info(s"\nThe $id doesn't present in the current items")
      updateCount
    } else {
      logger.info(s"\nenter the count to be updated the current count is ${itemMap(id).count}")
      val countToUpdate = readInt()
      val updatedItem = itemMap(id).copy(count = countToUpdate)
      itemMap + (id -> updatedItem)
    }
  }
}
