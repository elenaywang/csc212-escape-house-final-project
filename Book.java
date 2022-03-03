/** contains information about the book item */
public class Book {
  
  /** method for player to use the book 
   *  @param currentLocation  The room that the player is currently in
   */
  public static void useItem(String currentLocation) {
    if (Adventure.getInventory().contains("book")) {
      if (!Adventure.getInventory().contains("key")) {
        System.out.println("Carefully, you open the cover, but a cloud of dust still puffs into your face. You cough and wave the dust away for a few moments before the dust finally settles. At first glance, the book looks like an ordinary fairy tale picture book, but after flipping a few pages... wait, what was that? It appears that there is a key inside some hollowed out pages in the book...");
      } else {
        System.out.println("You look through the rest of the book, but everything else looks ordinary. It looks like this book has nothing left to offer.");
      }
    } else {
      System.out.println("You currently do not have access to the book. Please take the book before using.");
    }
  } // ~~END of useItem()~~ 
  

}
