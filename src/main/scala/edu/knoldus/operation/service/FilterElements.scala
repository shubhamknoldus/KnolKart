package edu.knoldus.operation.service

import edu.knoldus.application.ApplicationObject
import edu.knoldus.operation.classes.Item

import scala.io.StdIn._

object ImplicitObject {

  implicit class SortMap(mapToSort: Map[Int, Item]) {
    def sortByPrice: List[Item] = {
      mapToSort.values.toList.sortWith((a, b) => a.price <= b.price)
    }

    def sortByPriceHighToLow: List[Item] = {
      sortByPrice.reverse
    }

    def sortByCategory: List[Item] = {
      mapToSort.values.toList.sortWith((a, b) => a.category <= b.category)
    }
  }
}


case class FilterElements(mapToFilter: Map[Int, Item]) {

  import ImplicitObject._

  val logger = ApplicationObject.logger

  def filterElements: Map[Int, Item] = {
    if (mapToFilter.isEmpty) {
      logger.info("\n There are no items in the KnolKart please first add some elements and try again\n")
      mapToFilter
    } else {
      logger.info("Hi welcome to below are the products have a look !!")
      displaySortedElements(mapToFilter.sortByPrice)
      logger.info("\n press 1 for more filters else press 2\n")
      val choice = readInt()
      if (choice == 1) {
        logger.info("\nPress 1 to list items by price high to low\n" +
          "Press 2 to list items by category\n")
        val choice = readInt()
        if (choice == 1) {
          displaySortedElements(mapToFilter.sortByPriceHighToLow)
        }
        choice match {
          case 1 => displaySortedElements(mapToFilter.sortByPriceHighToLow)
          case 2 => displaySortedElements(mapToFilter.sortByCategory)
        }
      }
      mapToFilter
    }
  }

  private def displaySortedElements(listToDisplay: List[Item]): Unit = {
    listToDisplay.map(item => logger.info(s"\n${item.name}\t${item.description}\t${item.category}\t${item.price}\n"))
  }
}
