package com.DDPointofSale.web.controller;

import com.DDPointofSale.domain.dao.Transaction;
import com.DDPointofSale.domain.dto.TransactionDTO;
import com.DDPointofSale.domain.service.TransactionService;
import io.javalin.http.Context;
import io.javalin.validation.BodyValidator;
import jakarta.inject.Inject;
import org.jetbrains.annotations.NotNull;

import javax.xml.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TransactionController{
    private final TransactionService transactionService;

    @Inject
    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    public void getTransac(@NotNull Context context,@NotNull String id){
        try{
            var transaction = transactionService.getbyID(Integer.parseInt(id));
            if (transaction != null) {
                context.json(Map.of("transaction", transaction)).status(200);
            } else {
                context.json(Map.of("error", "Transaction not found")).status(404);
            }
        }catch (Exception e){
            context.json(Map.of("error", e.getMessage()))
                    .status(500);
        }
        return;
    }

    public void getAllTransac(@NotNull Context context){
        try{
            List<Transaction> transaction = transactionService.getAll();
            if(!transaction.isEmpty()){
                context.json(Map.of("Transactions",transaction)).status(200);
            }else {
               context.json(Map.of("error","Transactions are empty"))
                       .status(404);
            }
        }catch (Exception e){
            context.json(Map.of("Error",e.getMessage()))
                    .status(500);
        }


    }

    public void saveTransac(@NotNull Context ctx) {
        try{
            var transac = ctx.bodyValidator(TransactionDTO.class)
                    .check(it -> !it.getSales().isEmpty(),"Sales list is empty")
                    .check(it -> it.getPaytype() != null,"paytype is empty")
                    .check(it -> it.getTotal().floatValue() > 0.0, "total is empty or not valid")
                    .check(it -> it.getPayment().floatValue() > 0.0, "payment is empty or not valid")
                    .check(it -> it.getPurchasetype() != null,"purchasetype is empty");
            if(transac.errors().isEmpty()){
                var appended = transac.get();
                appended.setUsername(ctx.header("user"));
                var res = transactionService.processTransac(appended);
                ctx.json(Map.of("Status","Transaction processed and saved",
                        "Transactions",res))
                        .status(200);
            }else{
                ctx.json(Map.of("error",transac.errors()))
                        .status(500);
            }
        }catch (Exception e){
            ctx.json(Map.of("error",e.getMessage()))
                    .status(500);
        }
    }
}
