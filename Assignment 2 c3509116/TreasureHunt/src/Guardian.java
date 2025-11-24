/**
 * Represents a guardian that blocks treasure.
 *
 * @author Taru Nigam
 * @studentNo c3509116
 * @date 10 November 2025
 * @description Manages guardian fights based on strength.
 */
public class Guardian {
    private String name;
    private int strength;

    public Guardian(String name, int strength) {
        this.name = name;
        this.strength = strength;
    }

    /**
     * Handles fight logic.
     */
    public boolean fight(Player player) {
        System.out.println("A " + name + " blocks your way!");
        if (player.getAttack() >= strength) {
            System.out.println("You defeated the " + name + "!");
            return true;
        } else {
            int damage = strength - player.getAttack();
            player.takeDamage(damage);
            System.out.println("The " + name + " (" + strength + " strength) was too strong. You lost " + damage + " HP!");
            return false;
        }
    }

    public String getName() { return name; }
    public int getStrength() { return strength; }
}