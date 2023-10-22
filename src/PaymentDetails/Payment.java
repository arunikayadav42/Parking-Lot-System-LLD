package PaymentDetails;

public abstract class Payment {
    private PaymentStatus paymentStatus = PaymentStatus.UNPAID;

    public abstract boolean makePayment(Double amount);

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
