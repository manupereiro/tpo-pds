package system.university.pds.model;


import system.university.pds.model.interfaces.PaymentMethod;

public abstract class Payment {
    private PaymentMethod paymentMethod;
    private Order order;

    public Payment(Order order, PaymentMethod paymentMethod) {
        this.order = order;
        this.paymentMethod = paymentMethod;
    }

    public abstract PaymentMethod createPaymentMethod();

    public boolean pay(double amount) {
        if (paymentMethod.verifyPaymentMethod()) {
            paymentMethod.pay(amount);
            return true;
        }
        return false;
    }
}
