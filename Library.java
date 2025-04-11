/* This is a stub for the Library class */
import java.util.ArrayList;
import java.util.Hashtable;

public class Library extends Building implements LibraryRequirements {

  private Hashtable<String, Boolean> collection;

  /* Default constructor */
  public Library() {
    super();
    collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  /* Overloaded constructor with address only */
  public Library(String address) {
    super(address);
    collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  /* Overloaded constructor with name, address */
  public Library(String name, String address) {
    super(name, address);
    collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  /* Overloaded constructor with all parameters */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  /**
   * Adds a title to the library's collection.
   * Prints error message if title is already in the collection.
   * 
   * @param title The title to be added.
   */
  public void addTitle(String title) {
    if (title != null) {
      if (!this.containsTitle(title)) {
        collection.put(title, true);
        System.out.println("Added " + title + " to the collection.");
      } else {
        System.out.println(title + " is already in the collection.");
      }
    }
  }

  /**
   * Removes a title from the library's collection.
   * Prints error message if the title is not in the collection.
   * 
   * @param title The title to be removed.
   * @return The title that was removed, or null if the title was not found.
   */
  public String removeTitle(String title) {
    if (title != null) {
      if (this.containsTitle(title)) {
        collection.remove(title);
        return title;
      }
    }
    System.out.println("Title is either null or not in the collection.");
    return null;
  }

  /**
   * Checks out a book from the library's collection.
   * Prints error message if the title is not in the collection or is already
   * checked out.
   * 
   * @param title The title to be checked out.
   */
  public void checkOut(String title) {
    if (this.containsTitle(title) && this.isAvailable(title)) {
      collection.replace(title, false);
      System.out.println("Checked out " + title + ".");
    } else {
      System.out.println("Title is either checked out or not in the collection.");
    }
  }

  /**
   * Returns a book to the library's collection.
   * Prints error message if the title is not in the collection or is already
   * available.
   * 
   * @param title The title to be returned.
   */
  public void returnBook(String title) {
    if (this.containsTitle(title) && !this.isAvailable(title)) {
      collection.replace(title, true);
      System.out.println("Returned " + title + ".");
    } else {
      System.out.println("Title has either already been returned or is not in the collection.");
    }
  }

  /**
   * Checks if the library's collection contains a specific title.
   * 
   * @param title The title to check for.
   * @return true if the title is in the collection, false otherwise.
   */
  public boolean containsTitle(String title) {
    if (title != null) {
      return collection.containsKey(title);
    }
    return false;
  }

  /**
   * Checks if a title is available in the library's collection.
   * 
   * @param title The title to check for.
   * @return true if the title is available, false otherwise.
   */
  public boolean isAvailable(String title) {
    if (title != null) {
      if (collection.containsKey(title)) {
        return collection.get(title);
      }
    }
    return false;
  }

  /**
   * Prints the library's entire collection.
   * Displays each title and its availability status.
   */
  public void printCollection() {
    System.out.println("Library Collection:");
    String status = "";
    for (String title : collection.keySet()) {
      if (collection.get(title)) {
        status = "Available";
      } else {
        status = "Checked Out";
      }
      System.out.println("- " + title + ": " + status);
    }
  }

  /**
   * Navigates to a specific floor in the library using elevator.
   * @param floor The floor to navigate to.
   * @throws RuntimeException if the specified floor is out of range.
   * @throws RuntimeException if the user is not inside the library.
   * @throws RuntimeException if the user is already on the specified floor.
   */
  @Override
  public void goToFloor(int floor) {
    if (activeFloor == -1) {
      throw new RuntimeException("You are not inside this library. Must call enter() before navigating between floors.");
    }
    if (floor < 1 || floor > this.nFloors) {
      throw new RuntimeException("Invalid floor number. Valid range for this library is 1-" + this.nFloors + ".");
    }
    if (floor == this.activeFloor) {
      throw new RuntimeException("You are already on floor #" + floor + " of " + this.name);
    }
    activeFloor = floor;
    System.out.println("You are now on floor #" + activeFloor + " of " + this.name);
  }

  /**
   * Prints out a list of methods that can be called on the Library object.
   * Checks number of floors and displays options accordingly.
   * accordingly.
   */
  @Override
  public void showOptions() {
    System.out.println("Available options at " + this.name
        + ":\n + enter() \n + exit() \n + addTitle(title) \n + removeTitle(title) \n + checkOut(title) \n + returnBook(title) \n + containsTitle(title) \n + isAvailable(title)");
    if (this.nFloors > 1) {
      System.out.println(" + goUp() \n + goDown() \n  + goToFloor(n)");
    }
  }

  public static void main(String[] args) {
    Library neilson = new Library("Neilson Library", "7 Neilson Drive, Northampton MA 01063", 4);
    ArrayList<String> titles = new ArrayList<String>();
    titles.add("The Great Gatsby");
    titles.add("To Kill a Mockingbird");
    titles.add("1984");
    titles.add("Pride and Prejudice");
    titles.add("The Catcher in the Rye");
    for (String title : titles) {
      neilson.addTitle(title);
    }
    neilson.printCollection();
    neilson.checkOut("1984");
    neilson.checkOut("The Great Gatsby");
    neilson.checkOut("The Great Gatsby");

    neilson.showOptions();
  }
}