import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Saldo saldo1 = new Saldo();
        saldo1.deposit(1000000); // företagets konto
        System.out.println("Start saldo: " + saldo1.checkSaldo());
        //------------------------------------------------------------------------------
        boolean menu = true;
        while (menu == true) { //loop som gör att man kan fortsätta köra programmer efter varje val
            System.out.println("MENU \nVal 1 (Betala ut löner till anställda)\nVal 2 (Skapa en ny faktura)\nVal 3 (Betala en eller flera fakturor)\nVal 4 (Kolla kontosaldot)");
            Scanner sc = new Scanner(System.in);
            TryCatchMethods methods = new TryCatchMethods();
            int menyVal = methods.tryCatch1(); // tryCatch1
            System.out.println("Meny val: " + menyVal);
            //-------------------------------------------------------------------------------------
            switch (menyVal) { // meny med 4 val
                case 1: // Betala ut löner till anställda.
                    double[] aLöner;
                    System.out.println("Dags att välja hur många anställda du vill betala ut till!");
                    int aLängd = methods.tryCatch2(); // tryCatch2
                    aLöner = new double[aLängd];
                    System.out.println("array length: " + aLöner.length);
                    double sum = 0;
                    for (int i = 0; i < aLöner.length; i++) {
                        System.out.println("Dags att mata in löner!");
                        aLöner[i] = methods.tryCatch3(); // tryCatch3
                        sum = sum + aLöner[i];
                        System.out.println("_________________________________________\nArray position: " + i + " \nLön: " + aLöner[i] + "\nLön efter 30% skatteavdrag: " + aLöner[i] * 0.7 + "\n_________________________________________");
                    }
                    double sumMinusSkatt = sum * 0.7;
                    saldo1.withdraw(sum);
                    System.out.println("Summan som ska betalas ut från saldo: " + sum);
                    System.out.println("Summan av löner som ska betalas ut till anställda (skatt borttagen): " + sumMinusSkatt);
                    System.out.println("New balance: " + saldo1.checkSaldo());

                    break;
                    //------------------------------------------------------------------------------------
                case 2: // Skapa en ny faktura.
                    System.out.println("Här kommer du att skriva in totala summan på den nya fakturan!");
                    double brutto = methods.tryCatch3(); //tryCatch3
                    System.out.println("Brutto: " + brutto);
                    double moms = brutto * 0.25;
                    System.out.println("Moms: " + moms);
                    double netto = brutto * 0.75;
                    System.out.println("Netto: " + netto);
                    saldo1.deposit(netto);
                    System.out.println("New balance: " + saldo1.checkSaldo());
                    break;
                    //------------------------------------------------------------------------------------
                case 3: // Betala en eller flera fakturor.
                    double[] faktura;
                    System.out.println("Dags att välja hur många fakturor du vill skapa!");
                    int fLängd = methods.tryCatch2(); // tryCatch2
                    faktura = new double[fLängd];
                    System.out.println("array length: " + faktura.length);
                    double sum2 = 0;
                    double sum2MinusMoms = 0;
                    for (int i = 0; i < faktura.length; i++) {
                        System.out.println("Dags att mata in den totala summan för fakturan!");
                        faktura[i] = methods.tryCatch3(); // tryCatch3
                        sum2 = sum2 + faktura[i];
                        sum2MinusMoms = sum2 * 0.75;
                        System.out.println("_________________________________________\nArray position: " + i + " \nSumma: " + faktura[i] + "\nSumma efter 25% momsavdrag: " + faktura[i] * 0.75 + "\n_________________________________________");
                    }
                    System.out.println("Totala summan på alla fakturor: " + sum2);
                    System.out.println("Totala summan på alla fakturor - moms: " + sum2MinusMoms);
                    saldo1.withdraw(sum2MinusMoms);
                    System.out.println("New Balance: \n" + saldo1.checkSaldo() + " kr");
                    break;
                    //-------------------------------------------------------------------------------------------
                case 4: // Kolla saldo
                    System.out.println("Du har: \n" + saldo1.checkSaldo() + " kr på kontot");
                    break;
            }
            System.out.println("Vill du öppna menyn igen true/false?");
            menu = sc.nextBoolean(); // valet för att loopa tbx till menyn eller avsluta programmet
        }
        System.out.println("(Ool), Goodbye!");
    }
}
// vi får inte in någon moms och vi betalar ingen moms
//SE TILL ATT KOMMENTERA KODEN BÄTTRE, VAD KODEN GÖR OCH VARFÖR DEN GÖR SÅ.


/*

PSEUDO KOD UPPGIFT 1
PROCESS
    Initiera saldo
DISPLAY
    saldo
DISPLAY
    "Menu, please select one of the following"
    " val1: Betala ut löner till anställda, val2: Skapa ny faktura, val3: Betala en eller flera fakturor." Val4: Kolla saldo."
INPUT
    user selects one of (val1, val2, val3, val4)
PROCESS
    felhantering
____________________
Val1

DISPLAY
    "Fråga hur många anställda han vill betala ut till"
INPUT
    User väljer hur många anställda han vill betala ut till
PROCESS
    felhantering
    skapande av array med storlek(userinput)
DISPLAY
    "Be användaren mata in summan på lönerna"
INPUT
    user inputs doubles tills han matat in array.length
PROCESS
    felhantering
    forloop som lägger in löner på positioner upp till
    array.length och plussar på alla löner i variabeln
    double sum.
    Tot dras från saldo
DISPLAY
    "tot av löner som ska dras från saldo och totten - skatt som anställda sak få som lön."
    "Fråga användare om han vill öppna menyn igen eller avsluta programmet"
INPUT
    user true/false
PROCESS
    looop back to menu.
___________________________________________________________
DISPLAY
    "Menu, please select one of the following"
    " val1: Betala ut löner till anställda, val2: Skapa ny faktura, val3: Betala en eller flera fakturor." Val4: Kolla saldo."
INPUT
    user selects one of (val1, val2, val3, val4)
PROCESS
    felhantering
____________________
Val2

DISPLAY
    "Ber user att mata in totala summan av fakturan
INPUT
    user inputs tot
PROCESS
    felhantering
    programmet ska räkna ut moms 25%, brutto summa, netto summa
    netto summan ska plussa på saldo.
DISPLAY
    "program ska skirva ut moms, brutto och netto summan.
    "Fråga användare om han vill öppna menyn igen eller avsluta programmet true/false"
INPUT
    user true/false
PROCESS
    looop back to menu.
____________________
Val3

DISPLAY
    "be user att skriva in hur många fakturor hen vill betala"
INPUT
    User väljer hur många fakturor hen vill betala
PROCESS
    felhantering
    skapande av array med storlek(userinput)
DISPLAY
    "Be användaren mata in summan på faturorna"
INPUT
    user inputs doubles tills han matat in array.length
PROCESS
    felhantering
    forloop som lägger in fakturor på positioner upp till
    array.length och plussar på alla fakturor i variabeln
    double sum2.
    Tot dras från saldo - moms
DISPLAY
    "tot -moms av fakturarna som ska dras från saldo."
    "Fråga användare om han vill öppna menyn igen eller avsluta programmet"
INPUT
    user true/false
PROCESS
    looop back to menu.

 */