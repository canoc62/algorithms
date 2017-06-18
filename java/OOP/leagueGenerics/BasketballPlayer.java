/**
 * Created by canoc on 6/18/17.
 */
public class BasketballPlayer extends Player {

    public BasketballPlayer(String name) {
        super(name);
    }

    @Override
    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String getPosition() {
        return this.position;
    }

    public void shootBall() {
        System.out.println(this.getName() + " shoots the ball!");
    }
}
