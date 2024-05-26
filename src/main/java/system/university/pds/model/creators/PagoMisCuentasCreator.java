package system.university.pds.model.creators;

import system.university.pds.model.Order;
import system.university.pds.model.PagoMisCuentas;
import system.university.pds.model.Payment;
import system.university.pds.model.interfaces.PaymentMethod;

public class PagoMisCuentasCreator extends Payment {

    public PagoMisCuentasCreator(Order order, PaymentMethod paymentMethod) {
        super(order, paymentMethod);
    }

    @Override
    public PaymentMethod createPaymentMethod() {
        return new PagoMisCuentas();
    }
}
