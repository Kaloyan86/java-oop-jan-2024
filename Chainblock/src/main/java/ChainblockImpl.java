import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {

    //           id       Transaction
    private Map<Integer, Transaction> transactions;

    public ChainblockImpl() {
        this.transactions = new LinkedHashMap<>();
    }

    public int getCount() {
        return this.transactions.size();
    }

    public void add(Transaction transaction) {

        this.transactions.putIfAbsent(transaction.getId(), transaction);
    }

    public boolean contains(Transaction transaction) {
        return this.transactions.containsKey(transaction.getId());
    }

    public boolean contains(int id) {
        return this.transactions.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        Transaction transaction = this.getById(id);
        transaction.setStatus(newStatus);

    }

    public void removeTransactionById(int id) {
        Transaction transaction = this.transactions.remove(id);

        if (null == transaction) {
            throw new IllegalArgumentException();
        }
    }

    public Transaction getById(int id) {
        Transaction transaction = this.transactions.get(id);

        if (null == transaction) {
            throw new IllegalArgumentException();
        }

        return transaction;
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {

        List<Transaction> transactions = this.transactions
        .values()
        .stream()
        .filter(transaction -> transaction.getTransactionStatus().equals(status))
        .sorted((t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount()))
        .collect(Collectors.toList());

        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return transactions;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {

        List<Transaction> transactions = this.transactions
        .values()
        .stream()
        .filter(transaction -> transaction.getTransactionStatus().equals(status))
        .sorted((t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount()))
        .collect(Collectors.toList());

        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return transactions.stream()
                           .map(Transaction::getFrom)
                           .collect(Collectors.toList());
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        return null;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return null;
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        return null;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        return null;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return null;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        return null;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        return null;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return null;
    }

    public Iterator<Transaction> iterator() {
        return null;
    }
}
