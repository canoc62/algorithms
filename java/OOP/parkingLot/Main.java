public class Main {

    public static void main(String[] args) {
	// write your code here
        Lot target = new Lot("Target", 100, 25, 10, 65);

        Customer customer1 = new Customer("Customer1");
        customer1.setHandicapped();
        Customer customer2 = new Customer("Customer2");
        Customer customer3 = new Customer("Customer3");

        Employee employee1 = new Employee("Employee1", "CEO");
        Employee employee2 = new Employee("Employee2", "Software Engineer");

        target.occupyPublicSpace(customer2);
        target.occupyHandicappedSpace(customer1);
        target.occupyEmployeeSpace(employee1);
        target.occupyEmployeeSpace(employee2);
        target.occupyHandicappedSpace(customer3);
        //target.occupyEmployeeSpace(customer3); // Won't work, must be of type employee to take space

        System.out.println("Number of Target public spaces occupied: " + target.getNumPublicOccupied());
        System.out.println("Number of Target handicapped spaces occupied: " +  target.getNumHandicappedOccupied());
        System.out.println("Number of Target employee spaces occupied: " +  target.getNumEmployeeOccupied());
    }
}
