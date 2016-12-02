public class StringParser {



    //Solution 1:

    static String returnDirection(String x){

        //Always returns the first character as a lowercase

        return x.substring(0,1).toLowerCase();

    }

    //Return as a string

    static String returnDistance(String x){

        return x.substring(1).toLowerCase();

    }

    

    //Return as INT

    static int returnDistanceNum(String x){

        int result = Integer.parseInt(x.substring(1));

        return result;

    }

    

    //End solution 1

    

    //Solution 2

    static String DynamicParse(int i, String x){

        if(i == 0){

           return x.substring(0,1).toLowerCase(); 

        }

        if(i == 1){

           return x.substring(1).toLowerCase();

        }

        return null;

    }

    //End Solution 2

    

    

    /**

     * @param args the command line arguments

     */

    public static void main(String[] args) {

        // TODO code application logic here

        String x = "N267";

        String y = "Hello";

        String z = "100";

        returnDirection(y);

        /*System.out.println(returnDirection(y));

        System.out.println(returnDistance(y));

        System.out.println(DynamicParse(0,y));

        System.out.println(DynamicParse(1,y));

        System.out.println(DynamicParse(2,y));

        System.out.println(returnDistanceNum(z));*/

        

        System.out.println(returnDirection(x));

        System.out.println(returnDistanceNum(x));

        

    }

    

}
