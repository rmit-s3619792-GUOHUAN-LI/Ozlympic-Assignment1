//done by s3619792 Guohuan Li
public class Swimmer extends Athlete{
    private int id;
    public Swimmer(String _name,String _state,int _age){
        score=0;
        name=_name;
        state=_state;
        age=_age;
        ++num;
        type="swimmer";
        id=num;
    }
    public void compete(){
        time=(int)(Math.random()*100)+100;
    }
}
