//done by s3619792
public class Cyclist extends Athlete{
    private int id;
    public Cyclist(String _name,String _state,int _age){
        score=0;
        name=_name;
        state=_state;
        age=_age;
        ++num;
        type="cyclist";
        id=num;
    }
    public void compete(){
        time=(int)(Math.random()*300)+500;
    }
}
