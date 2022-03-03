import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

/**
 *  Sets up and runs game
 *
 *  @authors  Jamie Anderson, Margaret Zhang, Elena Wang
 *  @version CSC 212, December 2021
 */
public class Adventure {
  private static String currentLocation;
  private static HashMap<String, Room> roomMap;
  private static boolean isGameOver;
  private static ArrayList<String> inventory = new ArrayList<String>();
  private static Room currentRoom;

  /** getter for currentLocation */
  public static String getCurrentLocation() {
    return currentLocation;
  }

  /** getter for inventory */
  public static ArrayList<String> getInventory() {
    return inventory;
  }

  /** sets up the world of the game and runs the game */
  public static void main(String[] args) {
    // initializing attributes
    currentLocation = "Bedroom One";
    isGameOver = false;
     
    
    // 31-82: creating all room objects for house
    //hashmap for each room maps direction of door to room that it leads to
    HashMap<String, String> bedroomOneDir = new HashMap<>();
    bedroomOneDir.put("south", "Hallway");
    //array of items in room that user can take
    String[] bedroomOneItems = {"bed", "lamp", "book"};
    Room bedroomOne = new Room("Bedroom One", "You are in a bedroom. Everything is covered in dust. It looks like no one's been in here in years. A dim, flickering lamp is the only light source. On the bed, there is a book. Its green cover is coated with a thick layer of dust, enough that you can't make out what it says. The house is eerily quiet, but something tells you that the sooner you can get out, the better. A door to the SOUTH seems like the only way out of this room.", bedroomOneItems, false, false, bedroomOneDir);


    HashMap<String, String> hallwayDir = new HashMap<>();
    hallwayDir.put("north", "Bedroom One");
    hallwayDir.put("west", "Bathroom");
    hallwayDir.put("south", "Bedroom Two");
    hallwayDir.put("east", "Dining Room");
    String[] hallwayItems = {};
    Room hallway = new Room("Hallway", "You find yourself in a small hallway where you see three more closed doors. One to the WEST, one to the EAST, and one to the SOUTH. The only light comes from the room to the NORTH that you just came from. The walls are completely bare, except for what seem to be some dirty finger prints. Maybe it's just the light playing tricks, you think.", hallwayItems, false, false, hallwayDir);

    HashMap<String, String> bathroomDir = new HashMap<>();
    bathroomDir.put("east", "Hallway");
    String[] bathroomItems = {"toothbrush"}; 
    Room bathroom = new Room("Bathroom", "You are in a bathroom. There is only a toilet and a sink. Both are rusty and falling apart. An old, dirty toothbrush sits on the counter. A grimy window lets a small amount of light in, so it must be day time, but it's so dirty that you can't see out. The only exit is the door to the EAST that you came in through.", bathroomItems, false, false, bathroomDir);

    HashMap<String, String> bedroomTwoDir = new HashMap<>();
    bedroomTwoDir.put("north", "Hallway");
    bedroomTwoDir.put("down", "Basement");
    String[] bedroomTwoItems = {"bed", "poster", "paper"};
    Room bedroomTwo = new Room("Bedroom Two", "You are in another bedroom. This one looks almost the same as where you woke up. You see a bed and a poster taped onto the closet. It looks like it has a picture of some band on it. You've never heard of them though. It begins to feel like you aren't in the same world anymore. Something about this house seems familiar, but the harder you try to remember, the more confused you become. All you know is that you have to get out, so you try to focus on the present. Remembering can wait for another day. \n At first, it looks like the NORTH door you just came through is the only way out. But upon closer inspection, you notice a trapdoor that leads DOWN. Taped to the door is a faded piece of paper with the words 'WARNING. DO NOT ENTER.'", bedroomTwoItems, false, false, bedroomTwoDir);

    HashMap<String, String> basementDir = new HashMap<>();
    String[] basementItems = {};
    Room basement = new Room("Basement", "You have arrived in the basement. Everything is dark. Suddenly, the pressing silence of the house is broken by a booming voice. 'YOU HAVE FAILED TO HEED MY WARNING. NOW YOU MUST REMAIN HERE FOREVER. DON'T GET SO CAUGHT UP IN THE FUTURE NEXT TIME.' \n Oh no! You lost the game!", basementItems, true, false, basementDir);

    HashMap<String, String> diningRoomDir = new HashMap<>();
    diningRoomDir.put("west", "Hallway");
    diningRoomDir.put("north", "Kitchen");
    diningRoomDir.put("south", "Living Room");
    String[] diningRoomItems = {"chair"};
    Room diningRoom = new Room("Dining Room", "You are in the dining room, where you see a dining table and a few chairs around the room. The wood of the chairs is rotting and the table is stained with water rings and burn marks from years of loving use, now far in the past. Light from the windows illuminates the room. Windows! You look outside, but once again nothing looks familiar, other than the sun shining through the clouds. The neighborhood, if you can even call it that, around the house looks completely abandoned. By the looks of it, this house is the only one still standing. You look again, trying to find something to help you remember. Nothing comes to mind. The windows are securely locked. There are closed doors to the NORTH and SOUTH. The door to the WEST is the one you just came in through.", diningRoomItems, false, false, diningRoomDir);

    HashMap<String, String> kitchenDir = new HashMap<>();
    kitchenDir.put("south", "Dining Room");
    String[] kitchenItems = {"pen", "bulb"};
    Room kitchen = new Room("Kitchen", "You have entered the kitchen. It is almost completely dark except for a flickering bulb hanging from the ceiling, casting a yellowish glow. There is a landline PHONE on the countertop. The numbers on the buttons are faded and the counters are stained and scratched. Next to the phone, there is a sticky note, startlingly new compared to everything else in the house. It has a phone number written on it in black pen. The only door is the door to the SOUTH that you just came through.", kitchenItems, false, false, kitchenDir);

    HashMap<String, String> livingRoomDir = new HashMap<>();
    livingRoomDir.put("north", "Dining Room");
    livingRoomDir.put("south", "Porch");
    String[] livingRoomItems = {};
    Room livingRoom = new Room("Living Room", "You have entered the living room, where there are faded couches, a window, the door to the NORTH that you came through, and a door to the SOUTH with a padlock on it. A door! A glass door, through which you can see the outside! You are filled with excitement. If only that padlock wasn't there.", livingRoomItems, false, false, livingRoomDir);

    HashMap<String, String> porchDir = new HashMap<>();
    porchDir.put("north", "Living Room");
    String[] porchItems = {};
    Room porch = new Room("Porch","Outside at last! You take a deep breath of fresh air. Wait a minute, this doesn't seem like the neighborhood you saw from the window. The houses are in perfect condition, there are cars in the driveway and children playing in the yards. You blink slowly, as if coming out of a trance. You know this neighborhood. You realize that the porch on which you're standing belongs to the house next to yours. This house has been long abandoned, a for sale sign standing in the front lawn for as long as you've lived in the neighborhood. Questions flood your mind, so quickly you can't stop to think about any of them. That's when you notice a note at your feet. Picking it up, you read the messy hand writing: 'try not to focus on the FUTURE so much.' \n Congratulations! You won the game!", porchItems, true, true, porchDir);

    roomMap = new HashMap<>();
    roomMap.put("Bedroom One", bedroomOne);
    roomMap.put("Hallway", hallway);
    roomMap.put("Bathroom", bathroom);
    roomMap.put("Bedroom Two", bedroomTwo);
    roomMap.put("Basement", basement);
    roomMap.put("Dining Room", diningRoom);
    roomMap.put("Kitchen", kitchen);
    roomMap.put("Living Room", livingRoom);
    roomMap.put("Porch", porch);


    // --------- GAME BEGINS HERE ---------
    
    // introductory information
    System.out.println("As you slowly drift into consciousness, you realize that the air seems unusually still. In a jolt of panic, you open your eyes to see that you are in an unfamiliar place. You can't remember how you got here. Now, your mission is to find your way out of this place.");
    instructions();

    Scanner input = new Scanner(System.in);

    // prints description of the first room to begin the game
    printRoomDescription(); 
    
    // main game loop
    while (!isGameOver) {
      inputReader(input); // ask for input and acts accordingly
       
      resetIsGameOver(); // determines if the game should continue or not
    }

    System.out.println("\nThanks for playing!");
  } // ~~END of main()~~


  /** method that determines if the game should end or not; 
   *  resets the value of the isGameOver boolean attribute 
   */
  public static void resetIsGameOver() {
    if (!isGameOver) {
      isGameOver = roomMap.get(currentLocation).getIsEnd();
    }
  } // ~~END of resetIsGameOver()~~


  /** method that ends the game by setting isGameOver */
  public static void endGame() {
    isGameOver = true;
  } // ~~END of endGame()~~
  
  
  /** method that prints out the description of the room the user is currently in*/
  public static void printRoomDescription() {
    Room currentRoom = roomMap.get(currentLocation);
    System.out.println("\n" + currentRoom.getDescription());
  } // ~~END of printRoomDescription()~~


  /** method that reads and processes user input 
   *  @param sc Scanner to read user input 
   */
  public static void inputReader(Scanner sc) {
    System.out.print("Type your command here: ");
    String inputString = sc.nextLine().toLowerCase();
    String[] inputArray = inputString.split(" ");

    if (inputArray[0].equals("quit")) { 
      endGame(); // allows player to terminate game
    } else if (inputArray[0].equals("help")) {
      instructions(); // prints the game instructions
    } else if (inputArray.length != 2) { // invalid input length
      System.out.print("Please try again with a 2 word command. ");
      inputReader(sc); // prompt user again
    } else if (inputArray[0].equals("go")) {  // change rooms
      Room currentRoom = roomMap.get(currentLocation);
  
      try {
        moveRooms(inputArray[1]);
      } catch (NullDirectionException e) {
        // no room in the direction provided by user, so program asks for user input again
        inputReader(sc); // prompt user again
      }
      //use command allows player to use an object, specific to each item
    } else if (inputArray[0].equals("use")){
      if (inputArray[1].equals("key")) {
        usePorchKey(roomMap.get(currentLocation));
      } else if (inputArray[1].equals("phone")){
        Phone.useItem(currentLocation);
      } else if (inputArray[1].equals("book")){
        Book.useItem(currentLocation);
      } else {
        System.out.print("Sorry, you cannot use this item. Please try again. ");
        inputReader(sc);
      }
      //allows user to take item
    } else if (inputArray[0].equals("take")) {
      //special case for key, key is not in room inventory because it is hidden from player
      if (inputArray[1].equals("key")) {
        if (!inventory.contains("key")) {
          if (inventory.contains("book")) {
              inventory.add("key");
              System.out.println("key has been added to your inventory.");
          } else {
          System.out.println("Sorry, you don't have access to this item.");
          }
        } else {
          System.out.println("You already have this item.");
        }
        //if item is not the key, call takeItem
      } else {
        takeItem(inputArray[1]);
      }
      //allows user to view their inventory
    } else if (inputArray[0].equals("check")) {
      if (inputArray[1].equals("inventory")) {
        System.out.println("Inventory: " + inventory);
      } else {
        System.out.println("Sorry, this is not a valid command. Please try again.");
      }
      //catch all other commands
    } else {
      System.out.print("We don't recognize that command. Please try again. ");
      inputReader(sc);
    }
  } // ~~END of inputReader()~~
  

  /** method that changes which room the user is  *  currently in 
   *  @param direction: direction that player 
   *  wants to move
   */
  public static void moveRooms(String direction) {
    //allows access to room objects
    Room currentRoom = roomMap.get(currentLocation);

    if (currentRoom.getNeighborRoom(direction) == null) {
      System.out.print("There is no door here. Try a different direction: ");
      throw new NullDirectionException();

    } else if (roomMap.get(currentRoom.getNeighborRoom(direction)).getIsLocked()) {
      System.out.println("Sorry, this door is locked.");

    } else {
      currentLocation = currentRoom.getNeighborRoom(direction);
      printRoomDescription();
    }
  } // ~~END of moveRooms()~~


  /** prints instructions for the game */
  public static void instructions() {
    System.out.println("\n---------INSTRUCTIONS---------");
    System.out.println("When prompted, type the action you would like to perform.");
    System.out.println("Examples include:");
    System.out.println("\'go south\'\t to move into the room to the south of the room you are currently located in.");
    System.out.println("\'take item\'\t to add an item to your inventory.");
    System.out.println("\'use item\'\t to use an item's functionality.");
    System.out.println("\'check inventory\'\t to see all of the items in your inventory.");
    System.out.println("\'help\'\t to see the instructions.");
    System.out.println("\'quit\'\t to quit the game.");
    System.out.println("------------------------------\n");
  } // ~~END of instructions()~~
  
  
  /** method for player to use the key item to    *  unlock porch 
   *  @param currentRoom: player's current Room
   */
  public static void usePorchKey(Room currentRoom){
    if (inventory.contains("key")){
      if (currentLocation.equals("Living Room")) {
        System.out.println("You put the key into the hole in the padlock and turn. It easily pops open. You pull it off the door handle and drop it on the floor.");
        roomMap.get(currentRoom.getNeighborRoom("south")).setIsLocked(false);
      } else {
        System.out.println("There is nowhere to use the key in this room.");
      }
    } else {
      System.out.println("Sorry, you do not have this item.");
    }
  } // ~~END of usePorchKey()~~


  /** method to add item to inventory 
   *  @param item: item to take 
   */
  public static void takeItem(String item){
    String itemLowerCase = item.toLowerCase();
    if (inventory.contains(itemLowerCase)){
      System.out.println("You already have this item.");
    } else if (!arrayContains(roomMap.get(currentLocation).getRoomInventory(), item)) {
      System.out.println("Sorry. That item does not exist in this room.");
    } else {
      inventory.add(itemLowerCase);
      System.out.println(itemLowerCase + " has been added to your inventory.");
    }  
  } // ~~END of takeItem()~~ 
  
  
  /** 
   *  checks if an item is contained in a room's *  inventory array
   *  @param roomArray array to search
   *  @param item: item to search for 
   *  @return T/F returns true if array contains 
   *  item
   */
  public static boolean arrayContains(String[] roomArray, String item) {
    boolean inRoom = false;
    for (int i = 0; i < roomArray.length; i++) {
      
      if (roomArray[i].equals(item)) {
        inRoom = true;
      }
    }
    return inRoom;
  } // ~~END of arrayContains()~~
  
}



