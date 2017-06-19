import java.util.ArrayList;

/**
 * Created by canoc on 6/18/17.
 */
public class Lot {
    private String name;
    private int numIds = 0;
    private int totalSpaces;
    private int numEmployeeSpaces;
    private int numPublicSpaces;
    private int numHandicappedSpaces;
    private int numEmployeeOccupied = 0;
    private int numPublicOccupied = 0;
    private int numHandicappedOccupied = 0;
    private ArrayList<PublicSpace> publicSpaces = new ArrayList<>();
    private ArrayList<EmployeeSpace> employeeSpaces = new ArrayList<>();
    private ArrayList<HandicapSpace> handicapSpaces = new ArrayList<>();

    public Lot(String name, int spaces, int employeeSpaces, int handicappedSpaces, int publicSpaces) {
        this.name = name;
        this.totalSpaces = spaces;

        if ((employeeSpaces + publicSpaces) != spaces) {
            this.numEmployeeSpaces = spaces - (int)(spaces*0.25);
            this.numPublicSpaces =  spaces - (int)(spaces*0.65);
            this.numHandicappedSpaces = spaces - (int)(spaces*0.1);
        } else {
            this.numEmployeeSpaces = employeeSpaces;
            this.numHandicappedSpaces = handicappedSpaces;
            this.numPublicSpaces = publicSpaces;
        }

        for (int i = 1; i <= this.numEmployeeSpaces; i++) {
            this.employeeSpaces.add(new EmployeeSpace(++numIds));
        }

        for (int j = 1; j <= this.numPublicSpaces; j++) {
            this.publicSpaces.add(new PublicSpace(++numIds));
        }

        for (int k = 1; k <= this.numHandicappedSpaces; k++) {
            this.handicapSpaces.add(new HandicapSpace(++numIds));
        }
    }

    public Lot() {
        this("No Name", 100, 25, 10, 65);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public ArrayList<EmployeeSpace> getEmployeeSpaces() { // Change for immutability?
        //return new ArrayList<>(spaces);
        return employeeSpaces;
    }

    public ArrayList<HandicapSpace> getHandicapSpaces() {
        return handicapSpaces;
    }

    public int getNumEmployeeSpaces() {
        return numEmployeeSpaces;
    }

    public int getNumPublicSpaces() {
        return numPublicSpaces;
    }

    public int getNumHandicappedSpaces() {
        return numHandicappedSpaces;
    }

    public ArrayList<PublicSpace> getPublicSpaces() {

        return publicSpaces;
    }

    public void addEmployeeSpace() {
        this.employeeSpaces.add(new EmployeeSpace(++numIds));
        this.numEmployeeSpaces++;
        this.totalSpaces++;
    }

    public void addPublicSpace() {
        this.publicSpaces.add(new PublicSpace(++numIds));
        this.numPublicSpaces++;
        this.totalSpaces++;
    }

    public void addHandicappedSpace() {
        this.handicapSpaces.add(new HandicapSpace(++numIds));
        this.numHandicappedSpaces++;
        this.totalSpaces++;
    }

    public boolean occupyEmployeeSpace(Employee employee) {
        if (numEmployeeOccupied == numEmployeeSpaces) { //Change to compare to array list size
            System.out.println("Lot full!");
            return false;
        }

        for (EmployeeSpace space: employeeSpaces) {
            if (!space.isOccupied()) {
                space.setIsOccupied();
                numEmployeeOccupied++;
                return true;
            }
        }

        return false;
    }


    public boolean occupyPublicSpace(Person person) {
        if (numPublicOccupied == numPublicSpaces) {
            System.out.println("Lot full!");
            return false;
        }

        for (PublicSpace space: publicSpaces) {
            if (!space.isOccupied()) {
                space.setIsOccupied();
                numPublicOccupied++;
                return true;
            }
        }
        return false;
    }

    public int getNumEmployeeOccupied() {
        return numEmployeeOccupied;
    }

    public int getNumPublicOccupied() {
        return numPublicOccupied;
    }

    public int getNumHandicappedOccupied() {
        return numHandicappedOccupied;
    }

    public boolean occupyHandicappedSpace(Person person) {
        if (numHandicappedOccupied == numHandicappedSpaces) {
            System.out.println("Lot full!");
            return false;
        }

        if(!person.isHandicapped()) {
            System.out.println("This space is only for handicapped people!");
            return false;

        }

        for (HandicapSpace space: handicapSpaces) {
            if (!space.isOccupied()) {
                space.setIsOccupied();
                numHandicappedOccupied++;
                return true;
            }
        }
        return false;
    }

    private abstract class LotSpace {

        protected int id;
        protected boolean isOccupied;
        protected String type;
        protected Person occupier;

        public LotSpace(int id) {
            this.id = id;
            isOccupied = false;
            occupier = null;
        }

        public void setIsOccupied() {
            if (!this.isOccupied) this.isOccupied = true;
            else this.isOccupied = false;
        }

        public int getId() {
            return this.id;
        }

        public boolean isOccupied() {
            return this.isOccupied;
        }

        public abstract void describeSpace();
    }

    private class PublicSpace extends LotSpace {

        public PublicSpace(int id) {
            super(id);
        }

        public void describeSpace() {
            System.out.println("Public Space #" + this.id);
        }
    }

    private class HandicapSpace extends LotSpace {

        public HandicapSpace(int id) {
            super(id);
        }

        public void describeSpace() {
            System.out.println("Handicap Space #" + this.id);
        }
    }

    private class EmployeeSpace extends LotSpace {

        public EmployeeSpace(int id) {

            super(id);
        }

        public void describeSpace() {
            System.out.println("Employee Space #" + this.id);
        }
    }

}