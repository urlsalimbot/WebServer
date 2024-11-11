package com.DDPointofSale.domain.transaction;

import com.DDPointofSale.domain.sales.ISaleRepository;
import jakarta.inject.Inject;

public class TransactionService {
    ITransactionRepository transactions;
    ISaleRepository sales;

    @Inject
    public TransactionService(ITransactionRepository transactions, ISaleRepository sales) {
        this.transactions = transactions;
        this.sales = sales;
    }

}
