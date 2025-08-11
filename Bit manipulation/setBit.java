public class setBit {
    public static void main(String[] args)
    {
        int n=5;
        int pos=1;
        int bitMask=1<<pos;
        // set the bit at pos to 1
        int newNumber=bitMask|n;
        System.out.println(newNumber);
    }
}

// Empty editor settings 
