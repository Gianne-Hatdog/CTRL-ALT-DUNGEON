public abstract class Player extends Character {
    protected int level;
    protected int maxHealth;

    public Player(String name, int health, int attackDamage, int defense) {
        super(name, health, attackDamage, defense);
        this.maxHealth = health;
        this.level = 1;
    }

    public int getLevel() {
        return level;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void restoreFullHP() {
        this.health = maxHealth;
    }

    public void levelUp() {
    level++;

    // Increase stats
    maxHealth += 20;
    health = maxHealth;
    attackDamage += 5;
    defense += 2;

    // Increase class-specific resource
    if (this instanceof Mage) {
        ((Mage)this).levelUpMana();
    } else if (this instanceof Warrior) {
        ((Warrior)this).levelUpEnergy();
    }

    // Print level-up info
    System.out.println("\n=== LEVEL UP! ===");
    System.out.println("Level: " + level);
    System.out.println("Max HP increased to " + maxHealth);

    if (this instanceof Mage) {
        System.out.println("Max Mana increased to " + ((Mage)this).getMaxMana());
    } else if (this instanceof Warrior) {
        System.out.println("Max Energy increased to " + ((Warrior)this).getMaxEnergy());
    }

    System.out.println("Attack +5, Defense +2");
    System.out.println("HP and class resource fully restored!");
    System.out.println("=================\n");
    }
    
}
