import javax.swing.*;
import java.util.Random;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    boolean onLocation() {
        int obstacleNumber = this.randomObstacleNumber();
        System.out.println("You are here : " + this.getName());
        System.out.println("Please be careful ! " + this.getObstacle().getName() + " lives here !");
        System.out.println("There are " + obstacleNumber + " " + this.getObstacle().getName());

        // Determine who attacks first
        boolean playerTurn = new Random().nextBoolean();
        if (playerTurn) {
            System.out.println("It's your turn to attack !");
        } else {
            System.out.println("Enemy attacks first !");
        }

        System.out.println("--------------------");
        System.out.print("<F> Fight or <E> Escape -->");
        String selectCase = input.nextLine().toUpperCase();
        if (selectCase.equals("F")) {
            if (combat(obstacleNumber, playerTurn)) {
                System.out.println(this.getName() + " You won all obstacles !");
                return true;
            }
        } else if (selectCase.equals("E")) {
            System.out.println("You decided to escape !");
            return false;
        }

        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("You are dead ! :( ");
            return false;
        }
        return true;
    }

    public boolean combat(int obstacleNumber, boolean playerTurn) {
        for (int i = 1; i <= obstacleNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getDefaultHealth());
            playerStarts();
            obstacleStarts(i);

            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                if (playerTurn) {
                    System.out.println("--------------------");
                    System.out.print("<F> Fight or <E> Escape -->");
                    String selectCombat = input.nextLine().toUpperCase();
                    if (selectCombat.equals("F")) {
                        System.out.println("You hit the enemy!");
                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                    } else if (selectCombat.equals("E")) {
                        System.out.println("You decided to escape!");
                        return false;
                    }
                } else {
                    System.out.println("Enemy hits you!");
                    int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                    if (obstacleDamage < 0) {
                        obstacleDamage = 0;
                    }
                    this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                    afterHit();
                    System.out.println("Your health is now: " + this.getPlayer().getHealth());
                    System.out.println("Your armor is: " + this.getPlayer().getInventory().getArmor().getName());
                }

                playerTurn = !playerTurn;
            }

            if (this.getObstacle().getHealth() <= 0) {
                System.out.println("You defeated the enemy!");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Your current balance: " + this.getPlayer().getMoney());
            }

            if (this.getPlayer().getHealth() <= 0) {
                System.out.println("You are dead ! :(");
                return false;
            }
        }
        return true;
    }

    public void afterHit() {
        System.out.println("Current Your Health: " + this.getPlayer().getHealth());
        System.out.println("Current " + this.getObstacle().getName() + "'s Health: " + this.getObstacle().getHealth());
        System.out.println("--------");
    }

    public void playerStarts() {
        System.out.println("Player info:");
        System.out.println("--------------------");
        System.out.println("Health: " + this.getPlayer().getHealth());
        System.out.println("Weapon: " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Damage: " + this.getPlayer().getTotalDamage());
        System.out.println("Armor: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Block: " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Money: " + this.getPlayer().getMoney());
        System.out.println("--------------------");
    }

    public void obstacleStarts(int i) {
        System.out.println(i + ". " + this.getObstacle().getName() + " info:");
        System.out.println("--------------------");
        System.out.println("Health: " + this.getObstacle().getHealth());
        System.out.println("Damage: " + this.getObstacle().getDamage());
        System.out.println("Award: " + this.getObstacle().getAward());
    }

    public int randomObstacleNumber() {
        Random random = new Random();
        return random.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
