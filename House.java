/* This is a stub for the House class */
import java.util.ArrayList;

public class House extends Building implements HouseRequirements{

  private ArrayList<Student> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;
  private int nResidents;

  /* Default constructor */
  public House() {
    super();
    System.out.println("You have built a house: 🏠");
    residents = new ArrayList<Student>();
    hasDiningRoom = false;
    hasElevator = false;
    nResidents = 0;
  }

  /* Overloaded constructor with address only */
  public House(String address) {
    super(address);
    System.out.println("You have built a house: 🏠");
    residents = new ArrayList<Student>();
    hasDiningRoom = false;
    hasElevator = false;
    nResidents = 0;
  }

  /* Overloaded constructor with name, address */
  public House(String name, String address) {
    super(name, address);
    System.out.println("You have built a house: 🏠");
    residents = new ArrayList<Student>();
    hasDiningRoom = false;
    hasElevator = false;
    nResidents = 0;
  }

  /* Overloaded constructor with name, address, nFloors */
  public House(String name, String address, int nFloors) {
    super(name, address, nFloors);
    System.out.println("You have built a house: 🏠");
    residents = new ArrayList<Student>();
    hasDiningRoom = false;
    hasElevator = false;
    nResidents = 0;
  }

  /* Overloaded constructor with name, address, nFloors, DiningRoom */
  public House(String name, String address, int nFloors, boolean DiningRoom) {
    super(name, address, nFloors);
    System.out.println("You have built a house: 🏠");
    residents = new ArrayList<Student>();
    hasDiningRoom = DiningRoom;
    hasElevator = false;
    nResidents = 0;
  }
  
  /* Overloaded constructor with all parameters */
  public House(String name, String address, int nFloors, boolean DiningRoom, boolean Elevator) {
    super(name, address, nFloors);
    System.out.println("You have built a house: 🏠");
    residents = new ArrayList<Student>();
    hasDiningRoom = DiningRoom;
    hasElevator = Elevator;
    nResidents = 0;
  }

  /** Getter
   * @return a string representation of the House object
   */
  public boolean hasDiningRoom() {
    return hasDiningRoom;
  }

  /** Getter
   * @return a string representation of the House object
   */
  public int nResidents() {
    return nResidents;
  }

  /** Getter
   * @return a string representation of the House object
   */
  public boolean hasElevator() {
    return hasElevator;
  }

  /**
   * Adds student to house roster.
   * Increases resident count and prints confirmation message.
   * @param s the student to be added
   */
  public void moveIn(Student s) {
    residents.add(s);
    nResidents++;
    System.out.println(s.getName() + " has moved in.");
  }

  /**
   * Removes student from house roster.
   * Decreases resident count and prints confirmation message.
   * @param s the student to be removed
   * @return the student object if they were a resident, null otherwise
   */
  public Student moveOut(Student s) {
    if (residents.contains(s)) {
      residents.remove(s);
      nResidents--;
      System.out.println(s.getName() + " has moved out.");
      return s;
    } else {
      System.out.println(s.getName() + " is not a resident.");
      return null;
    }
  }

  /**
   * Checks if a student is a resident of the house.
   * @param s the student to check
   * @return true if the student is a resident, false otherwise
   */
  public boolean isResident(Student s) {
    if (residents.contains(s)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Navigates to a specific floor in the house.
   * If the house has an elevator, it will go directly to the specified floor.
   * If the house does not have an elevator, it will use stairs to go up or down one floor at a time.
   * @param floor The floor to navigate to.
   * @throws RuntimeException if the specified floor is out of range.
   * @throws RuntimeException if the user is not inside the house.
   * @throws RuntimeException if the user is already on the specified floor.
   * @throws RuntimeException if the house does not have an elevator and the user tries to move more than one floor at a time.
   */
  @Override
  public void goToFloor(int floor) {
    if (activeFloor == -1) {
      throw new RuntimeException("You are not inside this house. Must call enter() before navigating between floors.");
    }
    if (floor < 1 || floor > this.nFloors) {
      throw new RuntimeException("Invalid floor number. Valid range for this house is 1-" + this.nFloors + ".");
    }
    if (floor == this.activeFloor) {
      throw new RuntimeException("You are already on floor #" + floor + " of " + this.name);
    }
    if (!hasElevator && Math.abs(floor - this.activeFloor) > 1) {
      throw new RuntimeException("There is no elevator in this house. You can only use the stairs to go up or down one floor at a time.");
    }
    if (hasElevator) {
      activeFloor = floor;
      System.out.println("You have taken the elevator to floor #" + activeFloor + " of " + this.name);
      return;
    } 
    if (floor > activeFloor) {
      goUp();
    } else {
      goDown();
    }
    System.out.println("You have taken the stairs to floor #" + activeFloor + " of " + this.name);  
  }

  /**
   * Prints out a list of methods that can be called on the House object.
   * Checks if there is an elevator and displays options accordingly.
   */
  @Override
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + moveIn(s) \n + moveOut(s) \n + isResident(s)");
    if (hasElevator) {
      System.out.println("goToFloor(n)");
    }
  }
  public static void main(String[] args) {
    House park = new House("Park House", "134 Elm Street, Northampton MA 01063", 4, false, false);
    Student kim = new Student("Kimaya", "991445115", 2027);
    park.moveIn(kim);
    if (park.isResident(kim)) {
      System.out.println(kim.getName() + " is a resident of " + park.getName());
    } else {
      System.out.println(kim.getName() + " is not a resident of " + park.getName());
    }
    System.out.println(park);
    System.out.println("Number of residents: " + park.nResidents());
    park.moveOut(kim);
  }

}