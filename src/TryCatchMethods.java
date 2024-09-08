import java.util.Scanner;
public class TryCatchMethods {
//------------------------------------------------------------------------
    public int tryCatch1() {
        int answer1 = 0;
        while (answer1 <= 0 || answer1 > 4) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Välj mellan 1-4");
                answer1 = sc.nextInt();
            }
            catch (Exception e) {
                System.out.println("Error Code: " + e);
            }
            finally {
                //System.out.println("Finally");
            }
        }
            //System.out.println("Ool");
            return answer1;
    }
    //----------------------------------------------------------------------
    public int tryCatch2() {
        int answer2 = 0;
        while (answer2 <= 0 || answer2 > Integer.MAX_VALUE) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Mata in antalet!");
                answer2 = sc.nextInt();
            }
            catch (Exception e) {
                System.out.println("Error Code: " + e);
            }
            finally {
                //System.out.println("Finally");
            }
        }
            //System.out.println("Ool");
            return answer2;
    }
// -----------------------------------------------------------------------
    public double tryCatch3() {
        double answer3 = 0;
        while (answer3 <= 0 || answer3 > Double.MAX_VALUE) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Mata in värde!");
                answer3 = sc.nextDouble();
            }
            catch (Exception e) {
                System.out.println("Error Code: " + e);
            }
            finally {
                //System.out.println("Finally");
            }
        }
            //System.out.println("Ool");
            return answer3;
    }
//------------------------------------------------------------------------
}
