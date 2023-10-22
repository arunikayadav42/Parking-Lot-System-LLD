package PaymentDetails;

public class Cash extends Payment {
    @Override
    public boolean makePayment(Double amount) {
        System.out.println("Payment maid via Cash");
        this.setPaymentStatus(PaymentStatus.COMPLETED);
        return false;
    }
}
