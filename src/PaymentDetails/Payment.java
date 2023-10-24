package PaymentDetails;

public abstract class Payment {
    private PaymentStatus paymentStatus = PaymentStatus.UNPAID;

    public abstract boolean makePayment(final Double amount);

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(final PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
