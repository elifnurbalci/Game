public class River extends BattleLoc{

    public River(Player player) {
        super(player, "River", new Bear(), "Water",2);
    }
    @Override
    boolean onLocation() {
        boolean result = super.onLocation();
        if(result) {
            if(!getPlayer().hasAward("Water")) {
                getPlayer().addAward("Water");
                System.out.println("You've earned the Water award!");
            }
        }
        return result;
    }
}
