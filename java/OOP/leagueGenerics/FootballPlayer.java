public class FootballPlayer extends Player {

    public FootballPlayer(String name) {
        super(name);
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return this.position;
    }

    public void runBall() {
        System.out.println(this.getName() + " runs the ball!");
    }
}
