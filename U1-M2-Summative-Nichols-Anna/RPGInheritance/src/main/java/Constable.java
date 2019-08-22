public class Constable extends RpgClasses implements Base {

    private String jurisdiction;

    public Constable(String name, int strength, int health, int stamina, int speed, int attackPower) {
        super(name, strength, health, stamina, speed, attackPower);

        this.setName("Constable");
        this.setStrength(60);
        this.setHealth(100);
        this.setStamina(60);
        this.setSpeed(20);
        this.setAttackPower(5);
        this.setJurisdiction("Jurisdiction");
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    @Override
    public void run() {

    }

    public void arrest(){

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
