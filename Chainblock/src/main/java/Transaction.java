public interface Transaction {

    int getId();

    TransactionStatus getTransactionStatus();

    void setStatus(TransactionStatus newStatus);

    String getFrom();

    String getTo();

    double getAmount();
}
