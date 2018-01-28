package edu.knoldus.operation.classes

case class Item(name: String, price: Double, description: String, vendor: String, category: String, count: Int) {
  require(count > 0 && price > 0)

  override def toString: String = s"\nName of the item is $name\nPrice of the item is $price\n" +
    s"Description of the item $description\nVendor of the item $vendor\nCategory of the item $category" +
    s"\nCurrent count of the item $count"
}
