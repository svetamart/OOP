import java.util.ArrayList;
import java.util.Random;

public abstract class Hero implements BaseInterface {
    protected String name;
    protected static int number;
    protected int attack, defense, health, maxHealth, speed;
    protected int[] damage;

    public Hero(String name, int attack, int defense, int[] damage, int maxHealth, int speed) {
        this.name = String.format("%s_%d", name, ++Hero.number);
        this.attack = attack;
        this.defense = defense;
        this.damage = damage;
        this.maxHealth = maxHealth;
        this.health = maxHealth - new Random().nextInt(maxHealth);
        this.speed = speed;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Class: %s, Attack: %d, Defense: %d, Damage: %s, " +
                        "Max Health: %d, Health: %d, Health Level: %d%%, Speed: %d",
                this.name, this.getInfo(), this.attack, this.defense, showDPS(this.damage),
                this.maxHealth, this.health, this.getHealthLevel(), this.speed);
    }

    private String showDPS (int [] damage) {
        if (damage[0] == damage[1]) {
            return Integer.toString(damage[0]);
        }
        else {
            return String.format("%d-%d", damage[0], damage[1]);
        }
    }

    public long getHealthLevel() {
        double[] healthValues = new double[] {this.maxHealth, this.health};
        return Math.round(healthValues[1] / healthValues[0] * 100);

    }

    @Override
    public void step(ArrayList<Hero> list) {

    }

    @Override
    public String getInfo() {
        return this.getClass().getSimpleName();
    }

}
