public class Employee extends Person {

    private String title;

    public Employee(String name, String title) {

        super(name);
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void greeting() {
        System.out.println("Hello, my name is " + this.name + " and I'm an employee.");
    }
}
