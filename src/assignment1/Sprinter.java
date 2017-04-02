//done by s3619792 Guohuan Li
public class Sprinter extends Athlete{
    private int id;

    public Sprinter(String _name,String _state,int _age){
        score=0;
        name=_name;
        state=_state;
        age=_age;
        ++num;
        type="sprinter";
        id=num;
    }

    //compete the game time.
    public void compete(){
        time=(int)(Math.random()*10)+10;
    }
}
