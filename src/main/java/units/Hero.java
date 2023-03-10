package units;

import console.AnsiColors;

import java.util.List;
import java.util.Random;

public abstract class Hero implements BaseInterface {

    protected String teamColor;
    protected String textColor;
    protected String name, role = getClass().getSimpleName();
    protected String status;
    protected static int number;
    protected int attack, defense, maxHealth, speed;
    protected float health;
    protected int[] damageRange;

    protected List<Hero> team;
    protected Vector2 position;

    protected int num;

    protected Hero(String name, int attack, int defense, int[] damageRange, int maxHealth, int speed, String status) {
        this.name = String.format("%s_%d", name, ++Hero.number);
        this.attack = attack;
        this.defense = defense;
        this.damageRange = damageRange;
        this.status = status;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Class: %s, Attack: %d, Defense: %d, Damage: %s, " +
                        "Max Health: %d, Health: %d, Health Level: %d%%, Speed: %d",
                this.name, this.role, this.attack, this.defense, showDPS(this.damageRange),
                this.maxHealth, this.getHealth(), this.getHealthLevel(), this.speed);
    }


    protected float[] getTarget(List<Hero> list) {
        float[] result = new float[2];
        float minIndex = 0;
        float min = getPosition().distance(list.get(0).getPosition().x, list.get(0).getPosition().y);

        for (int i = 1; i < list.size(); i++) {
        float distance = getPosition().distance(list.get(i).getPosition().x, list.get(i).getPosition().y);
//            System.out.printf("%f, %s \n",
//                    getPosition().distance(target.getPosition().x, target.getPosition().y), target.getName());
        if (distance < min) {
            min = distance;
            minIndex = i;
        }
    }
        result[0] = min;
        result[1] = minIndex;

        return result;
    }

    public void takeDamage(float attackPower, Hero attacker) {
        if (attacker.role.equals("Sniper") || attacker.role.equals("Arbalester")) {
            if (this.defense > attacker.attack) {
                this.health -= (attackPower - 1);
                System.out.printf("%s%s%s ?????????????? ???????? %f. \n",
                        this.textColor, this.name, AnsiColors.ANSI_RESET, (attackPower - 1));
            } else if (this.defense < attacker.attack) {
                this.health -= (attackPower + 1);
                System.out.printf("%s%s%s ?????????????? ???????? %f. \n",
                        this.textColor, this.name, AnsiColors.ANSI_RESET, (attackPower + 1));
            } else {
                this.health -= attackPower;
                System.out.printf("%s%s%s ?????????????? ???????? %f. \n",
                        this.textColor, this.name, AnsiColors.ANSI_RESET, attackPower);
            }
        }
        else if (attacker.role.equals("Spearman") || attacker.role.equals("Rogue")) {
            this.health -= attackPower;
            System.out.printf("%s%s%s ?????????????? ???????? %f. \n",
                    this.textColor, this.name, AnsiColors.ANSI_RESET, attackPower);
        }

        if (this.health <= 0) {
            this.die();
        }
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

    protected boolean checkPosition(Vector2 position)
    {
        for (Hero hero: this.team) {
            if(hero.getPosition().isEqual(position) && hero.getStatus().equals("Alive"))
                return false;
        }
        return true;
    }

    public String getTeamColor() {
        return teamColor;
    }
    public String getName() { return name; }

    public String getStatus() { return status; }

    public Vector2 getPosition() { return position; }

    public int getSpeed() { return speed; }

    public int getHealth () { return (int) health; }

    public int getNum () { return num; }

    public void setNum() {
        Random rand = new Random();
        this.num = rand.nextInt(0, 1000);
    }


    @Override
    public void step(List<Hero> list) {
    }

    @Override
    public void die() {
            System.out.println(this.textColor + name + AnsiColors.ANSI_RESET + " ?????? ?????????????? ??????????????.");
            status = "Dead";
    }

    @Override
    public String getInfo() {
        if (status.equals("Alive")) {
            assert damageRange != null;
            return String.format("%s\t\uD83D\uDDE1??? %d\t\uD83D\uDEE1??? %d\t\uD83E\uDDE1 %d/%d\t\uD83C\uDFC3\u200D?????? %d",
                    name, attack, defense, getHealth(), maxHealth, speed);
        }
        else {
            return String.format("%s is dead \uD83D\uDC80", name);
        }
    }



}
