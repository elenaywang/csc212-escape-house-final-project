/** contains information about the phone item */
public class Phone {
  
  /** method for player to use the phone 
   *  @param currentLocation  The room that the player is currently in
   */
  public static void useItem(String currentLocation) {
    if (Adventure.getCurrentLocation().equals("Kitchen")){
      System.out.println("You call the number on the sticky note. You can hear the dial tone, but it goes on for so long that you're not sure if anyone will ever pick up. Just when you're about to lose hope, you hear someone pick up the phone. \"Look in the book,\" the garbled voice on the other end mutters before hanging up.");
    } else {
      System.out.println("You cannot use the phone from this location. Please go to the kitchen to use the phone.");
    }
  }

}