package units;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Hero implements BaseInterface {
    protected String name, role = getClass().getSimpleName();
    protected String status;
    protected static int number;
    protected int attack, defense, health, maxHealth, speed;
    protected int[] damageRange;
    protected int damage;

    protected List<Hero> team;
    protected Vector2 position;

    protected Hero(String name, int attack, int defense, int[] damageRange, int maxHealth, int speed, String status) {
        this.name = String.format("%s_%d", name, ++Hero.number);
        this.attack = attack;
        this.defense = defense;
        this.damageRange = damageRange;
        this.damage = (damageRange[0] + damageRange[1])/2;
        this.status = status;
        this.maxHealth = maxHealth;
        this.health = maxHealth - new Random().nextInt(maxHealth);
        this.speed = speed;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Class: %s, Attack: %d, Defense: %d, Damage: %s, " +
                        "Max Health: %d, Health: %d, Health Level: %d%%, Speed: %d",
                this.name, this.role, this.attack, this.defense, showDPS(this.damageRange),
                this.maxHealth, this.health, this.getHealthLevel(), this.speed);
    }

    protected String showDPS (int [] damage) {
        if (damage[0] == damage[1]) {
            return Integer.toString(damage[0]);
        }
        else {
            return String.format("%d-%d", damage[0], damage[1]);
        }
    }

    protected int getHealthLevel() {
        double[] healthValues = new double[] {this.maxHealth, this.health};
        return (int) Math.round(healthValues[1] / healthValues[0] * 100);

    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public int getDamage() { return damage; }

    public int getSpeed() { return speed; }

    @Override
    public void step(List<Hero> list) {

    }

    @Override
    public void die() {
            System.out.println(name + " пал смертью храбрых.");
            status = "Dead";
            team.remove(this);
    }

    @Override
    public String getInfo() {
        if (status.equals("Alive")) {
            assert damageRange != null;
            return String.format("%s\t\uD83D\uDDE1️ %d\t\uD83D\uDEE1️ %d\t\uD83E\uDDE1 %d\t️\uD83D\uDC4A %d\t\uD83C\uDFC3\u200D♂️ %d",
                    name, attack, defense, health, damage, speed);
        }
        else {
            return String.format("%s is dead \uD83D\uDC80", name);
        }
    }

    public Vector2 getPosition() {
        return position;
    }

}
