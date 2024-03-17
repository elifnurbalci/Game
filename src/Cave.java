public class Cave extends BattleLoc{
    public Cave(Player player) {
        super(player, "Cave", new Zombie(), "Food",3);
    }
    @Override
    boolean onLocation() {
        boolean result = super.onLocation();
        if(result) {
            if(!getPlayer().hasAward("Food")) {
                getPlayer().addAward("Food");
                System.out.println("You've earned the Food award!");
            }
        }
        return result;
    }
}
