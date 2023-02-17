package units;

import console.AnsiColors;

import java.util.List;

public abstract class Melee extends Hero {

    protected Melee(String name, int attack, int defense, int[] damageRange,
                    int maxHealth, int speed, String status) {
        super(name, attack, defense, damageRange, maxHealth, speed, status);
    }

    @Override
    public void step(List<Hero> list) {
        setNum();
        if (status.equals("Alive")) {
            List<Hero> targets = list.stream().filter(n -> n.getStatus().equals("Alive")).toList();
            if (!targets.isEmpty()) {
                Hero target = targets.get(((int) getTarget(targets)[1]));
                float targetDistance = getTarget(targets)[0];
                System.out.println(this.textColor + this.name + AnsiColors.ANSI_RESET +
                        " идет к " + target.textColor + target.name + AnsiColors.ANSI_RESET +
                        ". Расстояние до цели: " + targetDistance);

                if ((int) targetDistance <= 1) {
                    float attackPower = 0;
                    float damage = this.attack - target.defense;

                    if (damage == 0) {
                        attackPower = (float) (this.damageRange[0] + this.damageRange[1]) / 2;
                    } else if (damage > 0) {
                        attackPower = this.damageRange[1];
                    } else if (damage < 0) {
                        attackPower = this.damageRange[0];
                    }
                    System.out.printf("%s%s%s нанес удар %s%s%s. \n",
                            this.textColor, this.name, AnsiColors.ANSI_RESET,
                            target.textColor, target.name, AnsiColors.ANSI_RESET);
                    target.takeDamage(attackPower, this);
                    return;
                }

                float x = this.getPosition().x;
                float y = this.getPosition().y;

                if(target.getPosition().y > this.getPosition().y && this.checkPosition(new Vector2(x, ++y)))
                    this.position.y++;
                else if(target.getPosition().y < this.getPosition().y && this.checkPosition(new Vector2(x, --y)))
                    this.position.y--;
                else if(target.getPosition().x < this.getPosition().x && this.checkPosition(new Vector2(--x, y)))
                    this.position.x--;
                else if(target.getPosition().x > this.getPosition().x && this.checkPosition(new Vector2(++x, y)))
                    this.position.x++;

            }
        }
    }
}
