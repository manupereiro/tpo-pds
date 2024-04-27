package system.university.pds.model;

public class MercadoPago implements PaymentMethod{
    private double amount;

    public MercadoPago(double amount) {
        this.amount = amount;
    }

    @Override
    public void pay(double amount){
        System.out.println("Paying " + amount + " using MercadoPago");
    }

    @Override
    public boolean verifyPaymentMethod(){
        System.out.println("Verifying payment method using MercadoPago");
        System.out.println("Payment method verified successfully using MercadoPago");
        return true;
    }

}
