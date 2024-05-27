package system.university.pds.model;


import system.university.pds.model.interfaces.PaymentMethod;

public abstract class Payment {

    private Order order;

    public Payment(Order order) {
        this.order = order;

    }

    public abstract PaymentMethod createPaymentMethod();

}
