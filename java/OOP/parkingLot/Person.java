public abstract class Person {
    protected String name;
    private boolean isHandicapped = false;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = name;
    }

    public boolean isHandicapped() {
        return isHandicapped;
    }

    public void setHandicapped() {
        if(!isHandicapped) isHandicapped = true;
        else isHandicapped = false;
    }

    public abstract void greeting();
}