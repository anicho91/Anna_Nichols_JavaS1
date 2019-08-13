public class modulusAnimation {
    public static void main(String[] args) throws Exception{

        for ( int i=0; i<80; i++ )
        {
            if ( i%10 == 0 )
                System.out.print(" Mr. Mitchell is cool. \r");
            else if (i%10 == 1)
                System.out.println("  Mr. Mitchell is cool\r");

            Thread.sleep(200);
        }


    }
}
