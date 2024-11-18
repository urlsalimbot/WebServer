package com.DDPointofSale.domain.service;

import com.DDPointofSale.domain.Paytype;
import com.DDPointofSale.domain.dao.Customer;
import com.DDPointofSale.domain.dao.Sale;
import com.DDPointofSale.domain.dao.Transaction;
import com.DDPointofSale.domain.dto.LineChartDTO;
import com.DDPointofSale.domain.dto.SaleDTO;
import com.DDPointofSale.domain.dto.TransactionDTO;
import com.DDPointofSale.domain.repository.interfaces.IProductRepository;
import com.DDPointofSale.domain.repository.interfaces.ITransactionRepository;
import com.DDPointofSale.domain.repository.interfaces.IUserRepository;
import jakarta.inject.Inject;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

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

    public SaleDTO getSalesbyProductID(int id){
        var res = transactions.getsalesbyID(id);
        var topass = new SaleDTO();
        topass.setId(id);

        var tot = 0;
        for(Sale sale : res){
            tot = tot + sale.getQuantity();

        }
        topass.setQty(tot);
        return topass;
    }


    public Transaction getbyID(int i) {
        var res = transactions.findById(i);
        return res.orElse(null);
    }

    public List<Sale> getAll() {
        var res =transactions.findAllTransactions();

        List<Sale> filteredSales = res.stream()
                .filter(t -> t.getTransactiondate().isBefore(Instant.now()))
                .flatMap(t -> t.getSales().stream())
                .collect(Collectors.toList());

        return filteredSales;
    }


    public List<LineChartDTO> getMoneyLine(){
        var res = transactions.findAllTransactions();

        ArrayList<LineChartDTO> l = new ArrayList<>();
        Instant instant = Instant.now();
        ZonedDateTime here = ZonedDateTime.now().truncatedTo(ChronoUnit.DAYS);
        Instant parser = Instant.from(here);
        Instant yesterday = Instant.now().minus(1, ChronoUnit.DAYS);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM");

        int i = 0;
        for(i = 0; i < 8; i++) {
            float x = 0;
            var todayts = parser.minus(i,ChronoUnit.DAYS);
            var yesterparser = yesterday.minus(i,ChronoUnit.DAYS);
            for(Transaction t : res) {

                if(t.getTransactiondate().isBefore(todayts) && t.getTransactiondate().isAfter(yesterparser)) {
                    x = t.getTotal().floatValue();

                }
            }
            l.add(new LineChartDTO(yesterparser.atZone(ZoneId.systemDefault()).format(fmt).toString(), new BigDecimal(x)));
        }

        return l;
    }

    public Transaction processTransac(TransactionDTO transactionDTO) {
        var empInshift = users.getbyUsername(transactionDTO.getUsername());
        System.out.println(empInshift.toString());
        var customernow = new Customer();

        List<Sale> sales = new ArrayList<>();
        for (SaleDTO saleDTO : transactionDTO.getSales()) {
            var newsale = saleDTOtoSale(saleDTO);
            var prod = products.getbyId(saleDTO.getId()).get();
            prod.setStock(prod.getStock() - saleDTO.getQty());
            var updatedProduct  = products.updatebyID(prod,prod.getId());
            newsale.setProduct(updatedProduct.get());
            newsale.setUser(empInshift.orElse(null));
            sales.add(newsale);

        }

        var trans = Transaction.builder()
                .total(transactionDTO.getTotal())
                .payment(transactionDTO.getPayment())
                .change(transactionDTO.getPayment().subtract(transactionDTO.getTotal()))
                .customer_id(customernow)
                .sales(sales)
                .build();

        var res = transactions.save(trans);

        return res;
    }

    private Sale saleDTOtoSale(SaleDTO saleDTO) {
        return Sale.builder()
                .quantity(saleDTO.getQty())
                .build();
    }
}
