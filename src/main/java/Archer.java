public abstract class Archer extends Hero{

    int shots;
    public Archer(String name, int attack, int defense, int[] damage, int health, int speed, int shots) {
        super(name, attack, defense, damage, health, speed);
        this.shots = shots;
    }


    @Override
    public String toString() {
        return super.toString() + ", Shots: " + shots;
    }
}
