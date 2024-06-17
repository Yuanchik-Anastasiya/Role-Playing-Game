public class Bench extends Hero implements Trader {
    private int price = 10;
    private int gold = getGold_coins();

    public Bench(String name, int health, int gold_coins, int dexterity, int experience, int power) {
        super(name, health, gold_coins, dexterity, experience, power);
    }

    @Override
    public String sele(Things things) {
        String result = "";
        if (things == Things.POTION) {

            if (gold < price)
                return new String(new StringBuilder("Недостаточно монет"));
        }
        return result;
    }

    public enum Things {
        POTION
    }

}
