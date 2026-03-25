class Pokemon {
    int power;
    String type;

    Pokemon(String type, int power) {
        this.power = power;
        this.type = type;
    }
    Pokemon()
    {
        // default constuctor
    }
    void print() // getter
    {
        System.out.println(this.power + " " + this.type);
    }
}
class StrongPokemon extends Pokemon{
    int speed;
}

 class LegendaryPokemon extends Pokemon{ // sub/child/derived class
    String ability;
 }

class GodPokemon extends LegendaryPokemon{
    char tag;

} 

public class Inherit {
    public static void main(String[] args) {
        LegendaryPokemon mewtwo = new LegendaryPokemon();
        mewtwo.ability = "pressure";
        Pokemon pickachu = new Pokemon();


    }
}
