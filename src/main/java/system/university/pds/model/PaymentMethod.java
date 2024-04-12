package system.university.pds.model;

public interface PaymentMethod {

    void pay(double amount);
    boolean verifyPaymentMethod();
}
