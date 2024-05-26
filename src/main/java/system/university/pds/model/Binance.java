package system.university.pds.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import system.university.pds.model.interfaces.PaymentMethod;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Binance implements PaymentMethod {
    private double amount;

    @Override
    public void pay(double amount){
        System.out.println("Paying " + amount + " using Binance");
    }

    @Override
    public boolean verifyPaymentMethod(){
        System.out.println("Verifying payment method using Binance");
        System.out.println("Payment method verified successfully using Binance");
        return true;
    }
}
