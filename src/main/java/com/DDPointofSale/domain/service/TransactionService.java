package com.DDPointofSale.domain.service;

import com.DDPointofSale.domain.Paytype;
import com.DDPointofSale.domain.dao.Customer;
import com.DDPointofSale.domain.dao.Sale;
import com.DDPointofSale.domain.dao.Transaction;
import com.DDPointofSale.domain.dto.SaleDTO;
import com.DDPointofSale.domain.dto.TransactionDTO;
import com.DDPointofSale.domain.repository.interfaces.IProductRepository;
import com.DDPointofSale.domain.repository.interfaces.ITransactionRepository;
import com.DDPointofSale.domain.repository.interfaces.IUserRepository;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

public class TransactionService {
    private final ITransactionRepository transactions;
    private final IProductRepository products;
    private final IUserRepository users;

    @Inject
    public TransactionService(ITransactionRepository transactions,
                              IProductRepository products,
                              IUserRepository users) {
        this.transactions = transactions;
        this.products = products;
        this.users = users;
    }

    public Transaction getbyID(int i) {
        var res = transactions.findById(i);
        return res.orElse(null);
    }

    public List<Transaction> getAll() {
        return transactions.findAllTransactions();
    }

    public Transaction processTransac(TransactionDTO transactionDTO) {
        var empInshift = users.getbyUsername(transactionDTO.getUsername());
        var customernow = new Customer();

        List<Sale> sales = new ArrayList<>();
        for (SaleDTO saleDTO : transactionDTO.getSales()) {
            var newsale = saleDTOtoSale(saleDTO);
            var prod = products.getbyId(saleDTO.getProductid()).get();
            prod.setStock(prod.getStock() - saleDTO.getQuantity());
            var updatedProduct  = products.updateProduct(prod,prod.getProductname());
            newsale.setProduct(updatedProduct.get());
            newsale.setCustomer(customernow);
            newsale.setUser(empInshift.orElse(null));
            sales.add(newsale);

        }

        var trans = Transaction.builder()
                .total(transactionDTO.getTotal())
                .payment(transactionDTO.getPayment())
                .change(transactionDTO.getPayment().subtract(transactionDTO.getTotal()))
                .paytype(transactionDTO.getPaytype())
                .purchasetype(transactionDTO.getPurchasetype())
                .customer_id(customernow)
                .sales(sales)
                .build();

        var res = transactions.save(trans);

        return res;
    }

    private Sale saleDTOtoSale(SaleDTO saleDTO) {
        return Sale.builder()
                .quantity(saleDTO.getQuantity())
                .build();
    }
}
