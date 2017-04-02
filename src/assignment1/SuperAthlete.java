public class SuperAthlete extends Athlete{
    private int id;
    public SuperAthlete(String _name,String _state,int _age){
        score=0;
        name=_name;
        state=_state;
        age=_age;
        ++num;
        type="superathlete";
        id=num;
    }
    //superathlete can compete all the games.so we need select the game time for it.
    public void compete(){
        if(type=="swimmer"){
            time=(int)(Math.random()*300)+500;
        }else if(type=="cyclist"){
            time=(int)(Math.random()*300)+500;
        }else if(type=="sprinter"){
            time=(int)(Math.random()*10)+10;
        }
    }

}