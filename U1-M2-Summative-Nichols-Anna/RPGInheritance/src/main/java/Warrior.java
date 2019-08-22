public class Warrior extends RpgClasses implements Base {
    private int shieldStrength;

    public Warrior(String name, int strength, int health, int stamina, int speed, int attackPower, int shieldStrength) {
        super(name, strength, health, stamina, speed, attackPower);

        this.setName("Warrior");
        this.setStrength(75);
        this.setHealth(100);
        this.setStamina(100);
        this.setSpeed(50);
        this.setAttackPower(10);
        this.setShieldStrength(100);
    }

    public int getShieldStrength() {
        return shieldStrength;
    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }

    @Override
    public void run() {

    }

    @Override
    public void attack() {

    }

    @Override
    public void decreaseHealth() {

    }

    public void increaseHealth(){

    }

    @Override
    public void increaseStamina() {

    }

    @Override
    public void decreaseStamina() {

    }
}
