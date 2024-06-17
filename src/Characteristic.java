public abstract class Characteristic implements Attacks {
    private String name;
    private int health;
    private int gold_coins;
    private int dexterity;
    private int experience;
    private int power;
//    private int potion;

    public Characteristic(String name, int health, int gold_coins, int dexterity, int experience, int power) {
        this.name = name;
        this.health = health;
        this.gold_coins = gold_coins;
        this.dexterity = dexterity;
        this.experience = experience;
        this.power = power;
//        this.potion = potion;
    }


    @Override
    public int attack() {
        if (dexterity * 4 < getRundomValue())
            return power;
        else if (dexterity >= getRundomValue())
            return power * 2; //критический удар
        else return 0;
//        if (health == 0)
//            return health + potion;
    }

    private int getRundomValue() {
        return 0;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGold_coins() {
        return gold_coins;
    }

    public void setGold_coins(int gold_coins) {
        this.gold_coins = gold_coins;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return String.format("%s здоровье:%d", name, health);
    }

}
