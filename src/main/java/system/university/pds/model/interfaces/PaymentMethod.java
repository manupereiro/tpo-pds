package system.university.pds.model.interfaces;

public interface PaymentMethod {

    void pay(double amount);
    boolean verifyPaymentMethod();
}
