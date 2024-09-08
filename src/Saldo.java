public class Saldo {

    private double saldo;

    public void deposit (double amountIn) {
        saldo += amountIn;
    }
    public void withdraw (double amountOut) {
        if (amountOut <= saldo) {
            saldo = saldo - amountOut;
        } else {
            System.out.println("Insufficient funds");
        }
    }
    public double checkSaldo () {
        return saldo;
    }
}
