package com.DDPointofSale.domain.repository;

import com.DDPointofSale.Infrastructure.AppHibernate;
import org.junit.jupiter.api.Test;

class TransactionRepositoryTest {


    @Test
    public void wtf_isthis(){
        AppHibernate hibernate = new AppHibernate();
        TransactionRepository repo = new TransactionRepository(hibernate);

        var res = repo.getsalesbyID(3);
        System.out.println(res);
    }
}