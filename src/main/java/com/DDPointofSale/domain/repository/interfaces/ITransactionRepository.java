package com.DDPointofSale.domain.repository.interfaces;

import com.DDPointofSale.domain.dao.Transaction;

import java.util.List;
import java.util.Optional;

public interface ITransactionRepository {

    public Transaction save(Transaction transaction);

    public Optional<Transaction> findById(int id);

    public List<Transaction> findAllTransactions();
}
