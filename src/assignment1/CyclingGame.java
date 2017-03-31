import java.util.*;
public class CyclingGame extends Game{
    private ArrayList<Athlete> player_list;
    public CyclingGame(String _id){
        id=_id;
        type="cycling";
    }
    public void set_players(ArrayList<Athlete> players){
        player_list=players;
    }
    public boolean check_list_size(){
        if(4<=player_list.size()&&player_list.size()<=8){
            return true;
        }else{
            return false;
        }
    }
    public void set_official(Official official){
        official=official;
    }
    public int show_player_numbers(){
        return player_list.size();
    }
    public void game_begin(){
        int flag=-1;
        for(Athlete athlete:player_list){
            if(athlete.type=="superathlete"){
                athlete.type="swimmer";
                athlete.compete();
            }else{
                athlete.compete();
            }
            if(athlete.score!=0){
                athlete.score=0;
                flag=1;
            }
        }

        if(flag==1){
            System.out.println("You have rerun the game,so please predict the winner!");
            predict_winners();
        }

        //this method sort the ArrayList and add the score in the next step.
        Collections.sort(player_list,new Comparator<Athlete>(){
            @Override
            public int compare(Athlete o1,Athlete o2){
                if(o1.time>o2.time){
                    return 1;
                }else{
                    return -1;
                }
            }
        });

        for(int i=0;i<3;i++){
            if(i==0){
                if(player_list.get(i).name.equals(winner)){
                    System.out.println("congratulations ! you have preicted thw winner correctly!");
                }else{
                    System.out.println("Sorry..you are wrong.The winner is "+player_list.get(i).name);
                }
                player_list.get(i).score+=3;
            }else if(i==1){
                player_list.get(i).score+=2;
            }else if(i==2){
                player_list.get(i).score+=1;
            }
        }
    }

    public void predict_winners(){
        String _name;
        System.out.println("There are all the athletes that you can select.");
        for(Athlete athlete:player_list){
            System.out.println(athlete.name+" ");
        }
        System.out.println("");
        System.out.print("Enter the athlete name you want select:");
        int flag=-1;
        while(true){
            Scanner reader=new Scanner(System.in);
            _name=reader.next();
            for(Athlete athlete:player_list){
                if(athlete.name.equals(_name)){
                    winner=_name;
                    flag=1;
                    break;
                }
            }
            if(flag==-1){
                System.out.println("we can not find your input athlete name,plz check your input!");
            }else{
                break;
            }
        }
    }

    //this method show the player informations.
    public void show_player_informations(){
        System.out.println("Game id:"+id);
        for(Athlete athlete:player_list){
            System.out.println("Athele name:"+athlete.name+" Athlete score:"+athlete.score);
        }
    }
}