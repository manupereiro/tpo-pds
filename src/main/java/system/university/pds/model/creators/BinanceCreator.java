package system.university.pds.model.creators;

import system.university.pds.model.Binance;
import system.university.pds.model.Order;
import system.university.pds.model.Payment;
import system.university.pds.model.interfaces.PaymentMethod;

public class BinanceCreator extends Payment {

    public BinanceCreator(Order order, PaymentMethod paymentMethod) {
        super(order, paymentMethod);
    }

    @Override
    public PaymentMethod createPaymentMethod() {
        return new Binance();
    }
}
