package com.DDPointofSale.domain.transaction;

import io.javalin.http.Context;
import jakarta.inject.Inject;
import org.jetbrains.annotations.NotNull;

public class TransactionController{
    TransactionService transactions;

    @Inject
    public TransactionController(TransactionService transactions) {
        this.transactions = transactions;
    }

    public void getTransac(@NotNull Context context,@NotNull String id){

        return;
    }

    public void getAllTransac(@NotNull Context context){

        return;
    }

    public void getSaveTransac(@NotNull Context ctx) {
    }
}
