import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    /**
     * Returns CampusMap information as a readable string.
     * @return a string representation of the CampusMap object
     */
    public String toString() {
        String mapString = "DIRECTORY OF BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Cafe("Campus Center Cafe", "100 Elm Street Northampton, MA 01063"));
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Drive, Northampton MA 01063", 4));
        myMap.addBuilding(new Cafe("Compass Cafe", "7 Neilson Drive, Northampton MA 01063"));
        myMap.addBuilding(new House("Park House", "134 Elm Street, Northampton MA 01063", 4));
        myMap.addBuilding(new Library("Josten Library", "Mendenhall Center, 122 Green St, Northampton, MA 01063", 2));
        myMap.addBuilding(new House("Franklin King House", "180 Elm Street, Northampton MA 01063", 4, true, true));
        myMap.addBuilding(new House("Scales House", "170 Elm Street, Northampton MA 01063", 4, true, false));
        myMap.addBuilding(new Library("Hillyer Art Library", "22 Elm Street, Northampton MA 01063", 2));
        myMap.addBuilding(new House("1 Paradise Road, Northampton MA 01063"));
        myMap.addBuilding(new House("Haynes House", "1 Mandelle Road, Northampton MA 01063"));
        myMap.addBuilding(new Building("Seelye Hall", "7 Seelye Drive, Northampton MA 01063", 4));
        myMap.addBuilding(new Building());
        System.out.println(myMap);
        
    }
    
}
