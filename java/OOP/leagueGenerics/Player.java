/**
 * Created by canoc on 6/17/17.
 */
public abstract class Player {
    private String name;
    protected String position;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract void setPosition(String position);
    public abstract String getPosition();
}