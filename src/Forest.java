public class Forest extends BattleLoc{
    public Forest(Player player) {
        super(player, "Forest", new Vampire(), "Fire Wood",3);
    }

    @Override
    boolean onLocation() {
        boolean result = super.onLocation();
        if(result) {
            if(!getPlayer().hasAward("Fire Wood")) {
                getPlayer().addAward("Fire Wood");
                System.out.println("You've earned the Fire Wood award!");
            }
        }
        return result;
    }
}
