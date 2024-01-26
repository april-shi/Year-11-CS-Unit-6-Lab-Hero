import java.util.Random;
public class Hero {

    private String name;
    private int hitPoints;

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

        return "Hero{" + "name='" + getName() + "\'" + ", hitPoints=" + getHitPoints() + "}";

    }

    public void attack(Hero opponent) {

        Random random = new Random();
        double r = random.nextDouble(0,0.99);

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

        }

    }

    public String fightUntilTheDeath(Hero opponent) {

        this.senzuBean();
        opponent.senzuBean();

        fightUntilTheDeathHelper(opponent);

        return this.name + ": " + getHitPoints() + " " + opponent.name + ": " + opponent.getHitPoints();

    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n) {

        int hwins = 0;
        int owins = 0;

        int[] array = new int[2];

        for (int i = 0; i < n; i++) {

            fightUntilTheDeath(opponent);

            if (hitPoints == 0) {

                owins++;

            } else {

                hwins++;

            }

        }

        array[0] = hwins;
        array[1] = owins;

        return array;

    }

    public String nFightsToTheDeath(Hero opponent, int n) {

        int[] array = new int[2];

        array = nFightsToTheDeathHelper(opponent,n);

        String iLoveGladys = this.name + ": " + array[0] + " wins" + "\n" + opponent.name + ": " + array[1] + " wins" + "\n";

        if (array[0] == array[1]) {

            iLoveGladys += "OMG! It was actually a draw!";

        }

        if (array[0] > array[1]) {

            iLoveGladys += this.getName() + ": " + array[0] + " wins!";

        }

        if (array[1] > array[0]) {

            iLoveGladys += opponent.getName() + ": " + array[0] + " wins!";

        }

        return iLoveGladys;

    }

    public void dramaticFightToTheDeath(Hero opponent) throws InterruptedException {

        fightUntilTheDeath(opponent);
        Thread.sleep(1000);


    }


}
