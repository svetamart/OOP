public class Hero {
    protected String name;
    protected static int number;
    protected int attack, defense, health, speed;
    protected int[] damage;

    public Hero(String name, int attack, int defense, int[] damage, int health, int speed) {
        this.name = String.format("%s_%d", name, ++Hero.number);
        this.attack = attack;
        this.defense = defense;
        this.damage = damage;
        this.health = health;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Class: %s, Attack: %d, Defense: %d, Damage: %s, Health: %d, Speed: %d",
                this.name, this.getClass().getSimpleName(), this.attack, this.defense, showDamage(this.damage),
                this.health, this.speed);
    }

    private String showDamage (int [] damage) {
        if (damage[0] == damage[1]) {
            return Integer.toString(damage[0]);
        }
        else {
            return String.format("%d-%d", damage[0], damage[1]);
        }
    }
}
