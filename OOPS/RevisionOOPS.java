class Pokemon {
        private int power;
        String type;

        Pokemon(String type,int power)
        {
            this.power = power;
            this.type = type;
        }
        Pokemon(int power,String type)
        {
            this.power = power;
            this.type = type;
        }
        void print() // getter
        {
            System.out.println(this.power+" "+this.type);
        }
        int getPower()
        {
            return power;
        }
    }
public class RevisionOOPS {
    public static void main(String[] args) {
        Pokemon pikachu = new Pokemon("Electric",70);
        pikachu.type = "Fire";
        // pikachu.power = 34; Error
        Pokemon jigglypuff = new Pokemon(50,"fairy");
        pikachu.print(); jigglypuff.print();
        final int x = 89;  // x cant be changed
        
}
}