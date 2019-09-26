public class NestedLoops {

    public static void main( String[] args )
    {
        // this is #1 - I'll call it "CN"
        for ( int n=1; n <= 3; n++ )
        {

            for ( char c='A'; c <= 'E'; c++ ){
                System.out.println( c + " " + n );
            }
        }

        System.out.println("\n");

        // this is #2 - I'll call it "AB"
        for ( int a=1; a <= 3; a++ )
        {
            for ( int b=1; b <= 3; b++ )
            {
                System.out.print( a + "-" + b + " " );
            }
            System.out.println(a);
        }

        System.out.println("\n");

    }

}

// 1. The inner loop changes faster as the outer loop runs and then the inner loop repeats
// through the entire loop before the outer loop moves on the the next iteration of the loop

// 2. Because the are changed, the order now goes from A through E while the number stays the
// same until the A through E loop starts over

// 3. Print just print everything on the same line when adding an ln tells it to insert a line break

// 4. One it runs through the inner loop it moves to the sout(a) and prints just a and adds a
// line break before running through both loops again