import java.util.Random;

public class Mine extends BattleLoc {
    public Mine(Player player) {
        super(player, "Mine", new Snake(), "Random Item", 5);
    }

    @Override
    public boolean onLocation() {
        boolean result = super.onLocation();
        if (result) {
            giveRandomAward();
        }
        return result;
    }

    private void giveRandomAward() {
        Random random = new Random();
        int chance = random.nextInt(100) + 1;
        if (chance <= 50) {
            giveMoneyAward();
        } else if (chance <= 80) {
            giveArmorAward();
        } else {
            giveWeaponAward();
        }
    }

    private void giveMoneyAward() {
        Random random = new Random();
        int chance = random.nextInt(100) + 1;

        if (chance <= 50) {
            System.out.println("You found 1 gold!");
            getPlayer().setMoney(getPlayer().getMoney() + 1);
        } else if (chance <= 80) {
            System.out.println("You found 5 gold!");
            getPlayer().setMoney(getPlayer().getMoney() + 5);
        } else {
            System.out.println("You found 10 gold!");
            getPlayer().setMoney(getPlayer().getMoney() + 10);
        }
    }

    private void giveWeaponAward() {
        Random rand = new Random();
        int weaponChance = rand.nextInt(100) + 1;
        Weapon awardedWeapon;
        if (weaponChance <= 50) {
            awardedWeapon = Weapon.getWeaponObjectByID(1);
        } else if (weaponChance <= 80) {
            awardedWeapon = Weapon.getWeaponObjectByID(2);
        } else {
            awardedWeapon = Weapon.getWeaponObjectByID(3);
        }

        System.out.println("You've won a weapon: " + awardedWeapon.getName());
        getPlayer().getInventory().setWeapon(awardedWeapon);
    }

    private void giveArmorAward() {
        Random rand = new Random();
        int armorChance = rand.nextInt(100) + 1;
        Armor awardedArmor;

        if (armorChance <= 50) {
            awardedArmor = Armor.getArmorObjectByID(1);
        } else if (armorChance <= 80) {
            awardedArmor = Armor.getArmorObjectByID(2);
        } else {
            awardedArmor = Armor.getArmorObjectByID(3);
        }

        System.out.println("You've won an armor: " + awardedArmor.getName());
        getPlayer().getInventory().setArmor(awardedArmor);
    }
}
