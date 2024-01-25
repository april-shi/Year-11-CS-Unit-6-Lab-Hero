import java.util.Random;
public class Hero {

    Hero hero = new Hero();

    private String name;
    private int hitPoints;

    public Hero() {

    }

    public Hero(String name) {

        this.name = name;
        this.hitPoints = 100;

    }

    public String getName() {

        return name;

    }

    public int getHitPoints() {

        return hitPoints;

    }

    public String toString() {

        return "Hero{" + "name=" + "\'" + name + "\', " +
                "hitPoints=" + hitPoints() + "]";

    }

    public void attack(Hero opponent) {

        Random random = new Random();
        double r = random.nextDouble(0,0.99)

        if (r < 0.5) {

            hitPoints += 10;

        } else if (r >= 0.5) {

            opponent.hitPoints -= 10;

        }


    }

    public void senzuBean() {

        this.hitPoints = 100;

    }

    private void fightUntilTheDeathHelper(Hero opponent) {

        while (hitPoints > 0 && opponent.getHitPoints() > 0) {
            attack(opponent);
            if (opponent.getHitPoints() <= 0) {
                break;
            }
            opponent.attack(this);
            if (hitPoints <= 0) {
                break;
            }
        }

    }

    public String fightUntilTheDeath(Hero opponent) {

        this.senzuBean();

        fightUntilTheDeathHelper(opponent);

        return hero.name + ": " + getHitPoints() + " " + opponent.name + ": " + opponent.getHitPoints();

    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n) {

        fightUntilTheDeath(opponent);

        this.senzuBean();


    }

    public String nFightsToTheDeath(Hero opponent, int n) {

        nFightsToTheDeathHelper()

        return this.name + ": " + winz + "wins" + "\n" +
                opponent.name + ": " + winz + "wins" +

    }

    public void dramaticFightToTheDeath(Hero opponent) {

        while(this.hitPoints > 0) {

            fightUntilTheDeath(opponent);
            break;
        }

    }


}
