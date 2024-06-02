package election;

/**
 *
 * @author Yara
 */
public class Payment {

    private int paymentCode;
    private float amountPayment;
    private PaymentBehaviour paymentMethod;

    public Payment(int paymentCode, float amountPayment, PaymentBehaviour paymentMethod) {
        this.paymentCode = paymentCode;
        this.amountPayment = amountPayment;
        this.paymentMethod = paymentMethod;
    }

    Payment() {

    }

    public int getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(int paymentCode) {
        this.paymentCode = paymentCode;
    }

    public float getAmountPayment() {
        return amountPayment;
    }

    public void setAmountPayment(float amountPayment) {
        this.amountPayment = amountPayment;
    }

    public PaymentBehaviour getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentBehaviour paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void makePayment() {
        paymentMethod.makePayment();
    }
}
