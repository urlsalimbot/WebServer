package com.DDPointofSale.domain.transaction;

public interface ITransactionRepository {

    public void save(Transaction transaction);

    public Transaction findById(int id);

    public void findAllTransactions();
}
