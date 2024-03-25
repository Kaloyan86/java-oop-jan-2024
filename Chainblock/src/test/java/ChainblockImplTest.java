import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChainblockImplTest {

    private ChainblockImpl database;
    private List<Transaction> transactions;

    @Before
    public void setUp() {
        database = new ChainblockImpl();
        transactions = createTransactions();
    }

    @After
    public void tearDown() {
        this.database = new ChainblockImpl();
    }

    private List<Transaction> createTransactions() {
        return List.of(new TransactionImpl(1, TransactionStatus.FAILED, "Hristo", "Ivan", 57.65),
                       new TransactionImpl(2, TransactionStatus.UNAUTHORIZED, "Peter", "George", 89.45),
                       new TransactionImpl(3, TransactionStatus.ABORTED, "Petya", "Valya", 60.00),
                       new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "Martin", "Ivo", 47.35),
                       new TransactionImpl(5, TransactionStatus.FAILED, "Kaloyan", "Toni", 157.25));
    }

    private void fillDatabase() {

        this.transactions.forEach(transaction -> database.add(transaction));
    }

    @Test
    public void test_GetCount_Database_Empty() {

        assertEquals(0, this.database.getCount());
    }

    @Test
    public void test_GetCount_Database_Non_Empty() {

        fillDatabase();

        assertEquals(5, this.database.getCount());
    }

    @Test
    public void test_Add_Transaction_Successful() {
        Transaction transaction = transactions.get(0);

        this.database.add(transaction);

        assertTrue(String.format("Transaction with id %d is not added!", transaction.getId()),
                   database.contains(transaction));

        assertEquals(1, database.getCount());
    }

    @Test
    public void test_Add_Transaction_Exists() {
        Transaction transaction = transactions.get(0);

        this.database.add(transaction);
        this.database.add(transaction);

        assertEquals(1, database.getCount());
    }

    @Test
    public void test_Contains_Transaction_Exists() { // return true
        Transaction transaction = transactions.get(0);

        this.database.add(transaction);

        String assertMsg = String.format("Transaction with id %d does not exists", transaction.getId());

        assertTrue(database.contains(transaction));
        assertTrue(assertMsg, database.contains(transaction.getId()));
    }

    @Test
    public void test_Contains_Transaction_Non_Exists() { // return false
        Transaction transaction = transactions.get(0);

        String assertMsg = String.format("Transaction with id %d does exists", transaction.getId());

        assertFalse(database.contains(transaction));
        assertFalse(assertMsg, database.contains(transaction.getId()));
    }

    @Test
    public void test_ChangeTransactionStatus_Exists() {
        fillDatabase();

        database.changeTransactionStatus(3, TransactionStatus.SUCCESSFUL);

        Transaction transaction = database.getById(3);

        assertEquals(transaction.getTransactionStatus(), TransactionStatus.SUCCESSFUL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_ChangeTransactionStatus_Non_Exists() {
        fillDatabase();

        database.changeTransactionStatus(100, TransactionStatus.UNAUTHORIZED);
    }

    @Test
    public void test_GetById_Transaction_Exists() {
        fillDatabase();

        Transaction transaction = database.getById(2);

        assertEquals(TransactionStatus.UNAUTHORIZED, transaction.getTransactionStatus());
        assertEquals(2, transaction.getId());
        assertEquals(transaction.getFrom(), "Peter");
        assertEquals(transaction.getTo(), "George");
        assertEquals(transaction.getAmount(), 89.45, 0.01);

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetById_Transaction_Non_Exists() {
        database.getById(100);
    }

    @Test
    public void test_RemoveTransactionById_Transaction_Exists() {
        fillDatabase();

        this.database.removeTransactionById(2);

        assertEquals(4, database.getCount());
        assertFalse(this.database.contains(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveTransactionById_Non_Exists() {
        database.removeTransactionById(100);
    }

    @Test
    public void test_GetByTransactionStatus_Transaction_Exists() {
        fillDatabase();

        Iterable<Transaction> transactions = database.getByTransactionStatus(TransactionStatus.FAILED);
        List<Transaction> result = new LinkedList<>((Collection<Transaction>) transactions);

        Transaction transaction1 = result.get(0);
        Transaction transaction2 = result.get(1);

        assertEquals(157.25, transaction1.getAmount(), 0.01);
        assertEquals(57.65, transaction2.getAmount(), 0.01);

        transactions.forEach(transaction -> {
            assertEquals(TransactionStatus.FAILED, transaction.getTransactionStatus());
        });

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetByTransactionStatus_Non_Exists() {
        database.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
    }

    @Test
    public void test_GetAllSendersWithTransactionStatus_Transaction_Exists() {
        fillDatabase();

        this.database.add(new TransactionImpl(6, TransactionStatus.FAILED, "Kaloyan", "Sofia", 85.20));

        Iterable<String> allSendersWithTransactionStatus =
        database.getAllSendersWithTransactionStatus(TransactionStatus.FAILED);

        List<String> result = new LinkedList<>((Collection<String>) allSendersWithTransactionStatus);

        String sender1 = result.get(0);
        String sender2 = result.get(1);
        String sender3 = result.get(2);


        assertEquals("Kaloyan", sender1);
        assertEquals("Kaloyan", sender2);
        assertEquals("Hristo", sender3);

        assertEquals(3, result.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetAllSendersWithTransactionStatus_Non_Exists() {
        database.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
    }

    /*

    int getCount();
    void add(Transaction transaction);
    boolean contains(Transaction transaction);
    boolean contains(int id);
    void changeTransactionStatus(int id, TransactionStatus newStatus);
    void removeTransactionById(int id);
    Transaction getById(int id);
    Iterable<Transaction> getByTransactionStatus(TransactionStatus status);



    Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status);

    Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status);

    Iterable<Transaction> getAllOrderedByAmountDescendingThenById();

    Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender);

    Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver);

    Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount);

    Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount);

    Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi);

    Iterable<Transaction> getAllInAmountRange(double lo, double hi);
     */
}
