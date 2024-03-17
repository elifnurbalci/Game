import java.util.HashSet;
import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int defaultHeath;
    private int money;
    private String name;
    private String charName;
    Scanner input = new Scanner(System.in);
    private Inventory inventory;
    private HashSet<String> awards;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
        this.awards = new HashSet<>();
    }
    public void selectChar(){
        GameChar[] charList = {new Samurai(),new Archer(),new Knight()};
        System.out.println("Character List");
        System.out.println("------------------------------------------");
        for (GameChar gameChar : charList){
            System.out.println("Character ID:" +gameChar.getId() +
                    "\t\t Character: " +gameChar.getName() +
                    "\t\t Damage: " +gameChar.getDamage() +
                    "\t\t Health: " +gameChar.getHealth() +
                    "\t\t Money: " +gameChar.getMoney());
        }

        System.out.println("------------------------------------------");

        System.out.print("Please select your character ID: ");
        int selectChar = input.nextInt();

        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
                break;
        }
        System.out.println("Character: "+this.getCharName() +
                "  - Damage: "+this.getTotalDamage() +
                " - Health: "+this.getHealth() +
                " - Money: "+this.getMoney());
    }

    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setDefaultHeath(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }
    public void printInfo(){
        System.out.println("----- Current Weapon: " + this.getInventory().getWeapon().getName() +
                " - Current Armor: " + this.getInventory().getArmor().getName() +
                " - Block Info: " + this.getInventory().getArmor().getBlock() +
                " - Current Damage: " + this.getDamage() +
                " - Current Health: " + this.getHealth() +
                " - Balance: " + this.getMoney() + " -----");
    }
    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getDefaultHeath() {
        return defaultHeath;
    }

    public void setDefaultHeath(int defaultHeath) {
        this.defaultHeath = defaultHeath;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }
    public void addAward(String award) {
        this.awards.add(award);
    }

    public boolean hasAward(String award) {
        return this.awards.contains(award);
    }

    public boolean hasWonAllAwards() {
        return this.awards.size() == 3;
    }
    public HashSet<String> getAwards() {
        return new HashSet<>(this.awards);
    }

}
