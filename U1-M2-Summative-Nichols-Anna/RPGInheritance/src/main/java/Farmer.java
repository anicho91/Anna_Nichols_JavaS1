public class Farmer extends RpgClasses implements Base{


    public Farmer(String name, int strength, int health, int stamina, int speed, int attackPower) {
        super(name, strength, health, stamina, speed, attackPower);

        this.setName("Farmer");
        this.setStrength(75);
        this.setHealth(100);
        this.setStamina(75);
        this.setSpeed(10);
        this.setAttackPower(1);
    }

    @Override
    public void run() {

    }

    public void plow(){

    }

    public void harvest(){

    }

    @Override
    public void attack() {

    }

    @Override
    public void decreaseHealth() {

    }

    @Override
    public void increaseStamina() {

    }

    @Override
    public void decreaseStamina() {

    }
}
