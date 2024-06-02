package election;

/**
 *
 * @author Yara
 */
public class PayByCard implements PaymentBehaviour {

    @Override
    public void makePayment() {
        GUI_Payment_Card pay = new GUI_Payment_Card();
        pay.setVisible(true);
    }
}
