import java.util.*;
public abstract class Game{
    public String id;
    public Official official;
    public String type;
    public String winner;
    abstract int show_player_numbers();
    abstract void game_begin();
    abstract void predict_winners();
    abstract void show_player_informations();
}