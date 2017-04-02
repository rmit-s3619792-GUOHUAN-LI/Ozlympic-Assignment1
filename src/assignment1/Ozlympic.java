import java.util.*;
public class Ozlympic{
    public static Game current;
    public static ArrayList<Game> game_list=new ArrayList<Game>();

    public static void main(String[] args){
        generate_data();
        while(true){
            int n;
            int flag=-1;
            show_options();
            Scanner reader=new Scanner(System.in);
            System.out.print("Enter a option:");
            n=reader.nextInt();
            System.out.println();
            System.out.println();
            switch(n){
                case 1:
                    show_games();
                    break;
                case 2:
                    current.predict_winners();
                    break;
                case 3:
                    current.game_begin();
                    break;
                case 4:
                    display_final_result_of_games();
                    break;
                case 5:
                    display_the_points_of_all_athletes();
                    break;
                case 6:
                    flag=1;
                    break;
                default:
                    System.out.println("no this option!");
            }
            if(flag==1){
                break;
            }
        }
    }

    //this method display the result of the games.
    public static void display_final_result_of_games(){
        for(Game game:game_list){
            System.out.println("Game id:"+game.id);
            if(game.winner==null){
                System.out.println("the game is not compeleted.So there is no winner in this game.");
            }else{
            System.out.println("the game winner:"+game.winner);
            }
        }
    }

    //this method display all the points of athletes.
    public static void display_the_points_of_all_athletes(){
        for(Game game:game_list){
            game.show_player_informations();
        }
    }


    //this method generate the data of the games.
    public static void generate_data(){
        SwimmingGame sgame_1=new SwimmingGame("S01");
        sgame_1.set_official(new Official("of_1"));
        ArrayList<Athlete> temp=new ArrayList<Athlete>();
        Athlete[] test_list={new Swimmer("A_1","..",18),new Swimmer("B_1","..",20),new Swimmer("C_1","..",22),new Swimmer("D_1","..",23)};
        temp.addAll(Arrays.asList(test_list));
        sgame_1.set_players(temp);
        game_list.add(sgame_1);


        CyclingGame cgame_1=new CyclingGame("C01");
        cgame_1.set_official(new Official("of_2"));
        temp=new ArrayList<Athlete>();
        Athlete[] test_list_1={new Cyclist("A_2","..",18),new SuperAthlete("B_2","..",22),new Cyclist("C_2","..",23),new Cyclist("D_2","..",24),new Cyclist("E_2","..",24)};
        temp.addAll(Arrays.asList(test_list_1));
        cgame_1.set_players(temp);
        game_list.add(cgame_1);

        RunningGame rgame_1=new RunningGame("R01");
        rgame_1.set_official(new Official("of_3"));
        temp=new ArrayList<Athlete>();
        Athlete[] test_list_2={new Sprinter("A_3","..",18),new Sprinter("B_3","..",19),new Sprinter("C_3","..",20),new Sprinter("D_3","..",21),new SuperAthlete("E_3","..",24),new SuperAthlete("F_3","..",24)};
        temp.addAll(Arrays.asList(test_list_2));
        rgame_1.set_players(temp);
        game_list.add(rgame_1);

    }

    //this method show the option message.
    public static void show_options(){
        System.out.println();
        System.out.println();
        System.out.println("Ozlympic Game\n");
        System.out.println("===================================");
        System.out.println("1. Select a game to run");
        System.out.println("2. Predict the winner of the game");
        System.out.println("3. Start the game");
        System.out.println("4. Display the final results of all games");
        System.out.println("5. Display the points of all athletes");
        System.out.println("6. Exit");
        System.out.println("");
    }

    //this method show the game that user can predict.
    public static String show_games(){
        String _id;
        System.out.println("Therea are all the games you can select:");
        for(Game game:game_list){
            if(4<=game.show_player_numbers()&&game.show_player_numbers()<=8){
                System.out.print(game.id+" ");
            }
        }
        System.out.println("");
        int flag=-1;
        while(true){
            System.out.print("enter the game id that you want select:");
            Scanner reader=new Scanner(System.in);
            _id=reader.next();
            for(Game game:game_list){
                if(4<=game.show_player_numbers()&&game.show_player_numbers()<=8){
                    if(game.id.equals(_id)){
                        current=game;
                        flag=1;
                        break;
                    }
                }
            }
            if(flag==-1){
                System.out.println("we can not find your input game id,plz check your input!");
            }else{
                break;
            }
        }
        return _id;
    }
}