public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player, "Your Safe Home");
    }

    @Override
    public boolean onLocation() {
        System.out.println(".....You are at the safe area, you have FULL energy !.....");
        this.getPlayer().setHealth(this.getPlayer().getDefaultHeath());

        if (getPlayer().hasWonAllAwards()) {
            System.out.println("Congratulations! You have collected all the awards:");
            for(String award : getPlayer().getAwards()) {
                System.out.println("- " + award);
            }
            System.out.println("You have successfully completed the game. Well done!");
        } else {
            System.out.println("You still have some awards to collect. Keep exploring!");
        }

        return true;
    }

}
