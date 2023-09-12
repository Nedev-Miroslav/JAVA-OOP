package bank.core;

import bank.common.ConstantMessages;
import bank.common.ExceptionMessages;
import bank.entities.bank.Bank;
import bank.entities.bank.BranchBank;
import bank.entities.bank.CentralBank;
import bank.entities.client.Adult;
import bank.entities.client.Client;
import bank.entities.client.Student;
import bank.entities.loan.Loan;
import bank.entities.loan.MortgageLoan;
import bank.entities.loan.StudentLoan;
import bank.repositories.LoanRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {


    private LoanRepository loans;
    private Collection<Bank> banks;

    public ControllerImpl() {
        this.loans = new LoanRepository();
        this.banks = new ArrayList<>();
    }

    @Override
    public String addBank(String type, String name) {
        Bank bank = null;

        if (type.equals("CentralBank")) {
            bank = new CentralBank(name);
        } else if (type.equals("BranchBank")) {
            bank = new BranchBank(name);
        } else {
            throw new IllegalStateException(ExceptionMessages.INVALID_BANK_TYPE);
        }

        this.banks.add(bank);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String addLoan(String type) {
        Loan loan = null;

        if (type.equals("StudentLoan")) {
            loan = new StudentLoan();
        } else if (type.equals("MortgageLoan")) {
            loan = new MortgageLoan();
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_LOAN_TYPE);
        }

        this.loans.addLoan(loan);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String returnedLoan(String bankName, String loanType) {
        Loan loan = loans.findFirst(loanType);

        if (loan == null) {
            throw new IllegalStateException(String.format(ExceptionMessages.NO_LOAN_FOUND, loanType));
        }

        Bank bank = getBankByName(bankName);
        bank.addLoan(loan);
        this.loans.removeLoan(loan);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, loanType, bankName);
    }


    public Bank getBankByName(String bankName) {
        return this.banks.stream()
                .filter(b -> b.getName().equals(bankName))
                .findFirst()
                .get();
    }

    @Override
    public String addClient(String bankName, String clientType, String clientName, String clientID, double income) {
        Client client = null;
        if (clientType.equals("Student")) {
            client = new Student(clientName, clientID, income);
        } else if (clientType.equals("Adult")) {
            client = new Adult(clientName, clientID, income);
        } else {
            throw new IllegalStateException(ExceptionMessages.INVALID_CLIENT_TYPE);
        }

        Bank bank = getBankByName(bankName);

        boolean check1 = clientType.equals("Student") && bank.getClass().getSimpleName().equals("BranchBank");
        boolean check2 = clientType.equals("Adult") && bank.getClass().getSimpleName().equals("CentralBank");

        if (check1 || check2) {
            bank.addClient(client);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, clientType, bankName);
        } else {
            return ConstantMessages.UNSUITABLE_BANK;
        }


    }

    @Override
    public String finalCalculation(String bankName) {
        Bank bank = getBankByName(bankName);
        double sum = bank.getLoans().stream().mapToDouble(Loan::getAmount).sum();

        double sum1 = bank.getClients().stream().mapToDouble(Client::getIncome).sum();

        double finalSum = sum + sum1;


        return String.format(ConstantMessages.FUNDS_BANK, bankName, finalSum);

    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Bank bank : banks) {
            sb.append((bank.getStatistics())).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
