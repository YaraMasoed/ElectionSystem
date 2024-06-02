package election;

import javax.swing.JOptionPane;

/**
 *
 * @author Yara
 */
public class PayBYCash implements PaymentBehaviour {

    @Override
    public void makePayment() {
        JOptionPane.showMessageDialog(null, "Thank you your payment has been confirmed");
    }
}
