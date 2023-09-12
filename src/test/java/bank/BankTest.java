package bank;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BankTest {

    @Test
    public void testCreateBank() {
        Bank bank = new Bank("bankOne", 10);

        assertEquals("bankOne", bank.getName());
        assertEquals(10, bank.getCapacity());

    }

    @Test(expected = NullPointerException.class)
    public void testInvalidName() {
        Bank bank = new Bank("", 10);
    }

    @Test(expected = NullPointerException.class)
    public void testNullName() {
        Bank bank = new Bank(null, 10);
    }

    @Test
    public void testAddClient() {
        Bank bank = new Bank("bankOne", 10);

        Client client = new Client("John");
        assertEquals(0, bank.getCount());
        bank.addClient(client);
        assertEquals("John", client.getName());
        assertEquals(1, bank.getCount());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoCapacity() {
        Bank bank = new Bank("bankOne", -10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddClientNoCapacity() {
        Bank bank = new Bank("bankOne", 1);
        Client client1 = new Client("John");
        Client client2 = new Client("Jim");

        bank.addClient(client1);
        bank.addClient(client2);

    }

    @Test
    public void testRemoveClient() {
        Bank bank = new Bank("bankOne", 10);
        Client client1 = new Client("John");
        Client client2 = new Client("Jim");

        bank.addClient(client1);
        bank.addClient(client2);
        assertEquals(2, bank.getCount());
        bank.removeClient("Jim");
        assertEquals(1, bank.getCount());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveMissingClient() {
        Bank bank = new Bank("bankOne", 10);
        Client client1 = new Client("John");
        Client client2 = new Client("Jim");

        bank.addClient(client1);
        bank.addClient(client2);
        bank.removeClient("Sam");
    }

    @Test
    public void testLoanWithdrawal() {
        Bank bank = new Bank("bankOne", 10);
        Client client1 = new Client("John");
        bank.addClient(client1);
        bank.loanWithdrawal("John");
        assertFalse(client1.isApprovedForLoan());


    }

    @Test(expected = IllegalArgumentException.class)
    public void testLoanWithdrawalNotExist() {
        Bank bank = new Bank("bankOne", 10);
        Client client1 = new Client("John");
        bank.addClient(client1);
        bank.loanWithdrawal("Sam");
    }

    @Test
    public void testStatistics(){
        Bank bank = new Bank("bankOne", 10);
        Client client1 = new Client("John");
        Client client2 = new Client("Jim");

        bank.addClient(client1);
        bank.addClient(client2);

        assertEquals("The client John, Jim is at the bankOne bank!", bank.statistics());


    }


}