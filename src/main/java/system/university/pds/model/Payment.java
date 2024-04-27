package system.university.pds.model;

import java.util.List;

public class Payment {
    private PaymentMethod paymentMethod;
    private Order order;

    public Payment(Order order, PaymentMethod paymentMethod) {
        this.order = order;
        this.paymentMethod = paymentMethod;
    }

    public boolean pay(double amount) {
        if (paymentMethod.verifyPaymentMethod()) {
            paymentMethod.pay(amount);
            return true;
        }
        return false;
    }
}
