package PaymentDetails;

public class Card extends Payment {
    @Override
    public boolean makePayment(Double amount) {
        System.out.println("Payment made via Card");
        this.setPaymentStatus(PaymentStatus.COMPLETED);
        return true;
    }
}
