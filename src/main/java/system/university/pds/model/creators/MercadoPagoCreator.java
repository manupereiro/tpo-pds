package system.university.pds.model.creators;

import system.university.pds.model.MercadoPago;
import system.university.pds.model.Order;
import system.university.pds.model.Payment;
import system.university.pds.model.interfaces.PaymentMethod;

public class MercadoPagoCreator extends Payment {

    public MercadoPagoCreator(Order order) {
        super(order);
    }

    @Override
    public PaymentMethod createPaymentMethod() {
        return new MercadoPago();
    }

}
