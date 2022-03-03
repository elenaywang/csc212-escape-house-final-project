import java.util.HashMap;

/** represents the rooms of the house */
public class Room {
  /** name of room */
  private String roomName;
  /** description of the room */
  private String description;
  /** inventory of takeable items in the room */
  private String[] roomInventory;
  /** whether the room is a terminal location */
  private boolean isEnd;
  /** whether room is inaccessible */
  private boolean isLocked;
  /** stores each direction and their associated rooms */
  private HashMap<String,String> directions;


  
  /** constructor */
  public Room(String roomName, String description, String[] roomInventory, Boolean isEnd, Boolean isLocked, HashMap<String,String> directions) {
    this.roomName = roomName;
    this.description = description;
    this.roomInventory = roomInventory;
    this.isEnd = isEnd;
    this.isLocked = isLocked;
    this.directions = directions;
  }

  /** method that returns the room name in the house graph */
  public String toString() {
    return this.roomName;
  }
  
  /** @return String room description */
  public String getDescription() {
    return this.description;
  }

  /** @return T/F returns true if room is a terminal location */
  public boolean getIsEnd() {
    return this.isEnd;
  }

  /** getter to see if room is inaccessible 
   *  @return boolean returns true if room is 
   *  is inaccessible
   */
  public boolean getIsLocked() {
    return this.isLocked;
  }

  /** sets isLocked
   *  @param newIsLocked boolean to set isLocked
   */
  public void setIsLocked(boolean newIsLocked) {
    isLocked = newIsLocked;
  }

  /** @return String[] roomInventory */
  public String[] getRoomInventory() {
    return roomInventory;
  }
  
  /** getter to see the rooms that are connected to inputted direction
   *  @param direction of where you are looking
   *  @return rooms that connected to given direction of the room
   */ 
  public String getNeighborRoom(String direction) {
    return directions.get(direction); 
  }
  
}