public class Customer extends Person {

    public Customer(String name) {
        super(name);
    }

    public void greeting() {
        System.out.println("Hello, my name is " + this.name);
    }
}