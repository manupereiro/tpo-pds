package system.university.pds.model;

import java.util.List;

public class Payment {
    private PaymentMethod paymentMethod;
    private Order order;

    public boolean pay(double amount) {
        if (paymentMethod.verifyPaymentMethod()) {
            paymentMethod.pay(amount);
            return true;
        }
        return false;
    }

    public List<Course> getCourses() {
        return order.getCourses();
    }
}
