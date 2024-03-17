import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("Welcome to the jungle!");
        System.out.print("Please write your name: ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Hello "+playerName +" ! Are you ready to discover the real world !");
        System.out.println("Please select your character: ");

        Location location = null;
        player.selectChar();
        while (true){
            System.out.println();
            player.printInfo();
            System.out.println();
            System.out.println("##### Areas #####");
            System.out.println();
            System.out.println("1 - Safe House --> Relax and refresh !");
            System.out.println("2 - Tool Store --> Buy weapons and armors");
            System.out.println("3 - Go to Cave --> Award is Food - Please be careful ! Zombies live here");
            System.out.println("4 - Go to Forest --> Award is Fire Wood - Please be careful ! Vampires live here");
            System.out.println("5 - Go to River --> Award is Water - Please be careful ! Bears live here");
            System.out.println("6 - Go to Mine --> Award is Random Item - Please be careful! Snakes live here");
            System.out.println("0 - Exit");
            System.out.println();
            System.out.print("Please select your location: ");
            int selectLoc = input.nextInt();
            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                case 6:
                    location = new Mine(player);
                    break;
                default:
                    System.out.println("Invalid input !");
            }
            if(location == null) {
                System.out.println("Good Bye ! See you soon...");
                break;
            }
            if(!location.onLocation()){
                System.out.println("Game Over ! :(");
            }
        }
    }
}
