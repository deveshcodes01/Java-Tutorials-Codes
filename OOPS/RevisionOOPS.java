public class RevisionOOPS {
    private static class Pokemon {
        private int power;
        String type;

        Pokemon(String type,int power)
        {
            this.power = power;
            this.type = type;
        }
        void print()
        {
            System.out.println(this.power+" "+this.type);
        }
    }

    public static void main(String[] args) {
        Pokemon pikachu = new Pokemon("Electric",70);
        pikachu.type = "Fire";
        // pikachu.power = 34; Error
        Pokemon jigglypuff = new Pokemon("fairy",50);

        pikachu.print(); jigglypuff.print();
}
}