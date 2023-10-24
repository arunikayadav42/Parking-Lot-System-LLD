package PaymentDetails;

public class Cash extends Payment {
    @Override
    public boolean makePayment(final Double amount) {
        System.out.println("Payment made via Cash");
        this.setPaymentStatus(PaymentStatus.COMPLETED);
        return false;
    }
}
