package system.university.pds.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import system.university.pds.model.interfaces.PaymentMethod;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PagoMisCuentas implements PaymentMethod {
    private double amount;

    @Override
    public void pay(double amount){
        System.out.println("Paying " + amount + " using PagoMisCuentas");
    }

    @Override
    public boolean verifyPaymentMethod(){
        System.out.println("Verifying payment method using PagoMisCuentas");
        System.out.println("Payment method verified successfully using PagoMisCuentas");
        return true;
    }
}
