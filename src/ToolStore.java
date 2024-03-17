public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println(".....Shopping Time !.....");
        boolean showMenu = true;
        while (showMenu) {
                System.out.println("1 - Weapons");
                System.out.println("2 - Armors");
                System.out.println("3 - Exit");
                System.out.print("Please select something: ");
                System.out.println();
                int selectCase = input.nextInt();
                while (selectCase < 1 || selectCase > 3) {
                    System.out.print("Invalid input, please try again: ");
                    selectCase = input.nextInt();
                }
                switch (selectCase){
                    case 1:
                        printWeapon();
                        buyWeapon();
                        break;
                    case 2:
                        printArmor();
                        buyArmor();
                        break;
                    case 3:
                        showMenu = false;
                        break;

            }
        }
        return true;
    }

    private void printWeapon() {
        System.out.println("##### Weapons #####");
        System.out.println();
        for (Weapon weapon : Weapon.weapons()){
            System.out.println("ID: " + weapon.getId() + " - Weapon Name: " + weapon.getName() +
                    " - Price: " + weapon.getPrice() + " - Damage: " + weapon.getDamage());
        }
        System.out.println("0 - Exit");

    }

    public void buyWeapon(){
        System.out.print("Please select a weapon: ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length){
            System.out.print("Invalid input, please try again: ");
            selectWeaponID = input.nextInt();
        }
        if(selectWeaponID != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjectByID(selectWeaponID);

            if (selectedWeapon != null){
                if(selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("No credit !");
                }else{
                    System.out.println(selectedWeapon.getName() + " was taken !");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Balance: " + this.getPlayer().getMoney());
                    System.out.println("Previous weapon: " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Current weapon: " + this.getPlayer().getInventory().getWeapon().getName());

                }
            }
        }

    }
    private void printArmor() {
        System.out.println("##### Armors #####");
        System.out.println();
        for (Armor armor : Armor.armors()){
            System.out.println("ID: " + armor.getId() + " - Armor Name: " + armor.getName() +
                    " - Price: " + armor.getPrice() + " - Block Level: " + armor.getBlock());
        }
        System.out.println("0 - Exit");
    }
    public void buyArmor() {
        System.out.print("Please select an armor: ");
        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length){
            System.out.print("Invalid input, please try again: ");
            selectArmorID = input.nextInt();
        }
        if(selectArmorID != 0) {
            Armor selectedArmor = Armor.getArmorObjectByID(selectArmorID);

            if (selectedArmor != null){
                if(selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("No credit !");
                }else{
                    System.out.println(selectedArmor.getName() + " was taken !");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Balance: " + this.getPlayer().getMoney());
                    System.out.println("Previous armor: " + this.getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Current armor: " + this.getPlayer().getInventory().getArmor().getName());

                }
            }
        }

    }
}
