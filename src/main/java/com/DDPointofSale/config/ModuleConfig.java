package com.DDPointofSale.config;

import com.DDPointofSale.Infrastructure.AppHibernate;
import com.DDPointofSale.domain.sales.ISaleRepository;
import com.DDPointofSale.domain.sales.SaleRepository;
import com.DDPointofSale.domain.transaction.ITransactionRepository;
import com.DDPointofSale.domain.transaction.TransactionRepository;
import com.DDPointofSale.domain.transaction.TransactionService;
import com.DDPointofSale.domain.user.IUserRepository;
import com.DDPointofSale.domain.user.UserRepository;
import com.DDPointofSale.domain.user.UserService;
import com.google.inject.AbstractModule;
import jakarta.inject.Singleton;

public class ModuleConfig extends AbstractModule {

    @Override
    protected void configure() {
        bind(UserService.class);
        bind(IUserRepository.class).to(UserRepository.class).in(Singleton.class);

        bind(TransactionService.class);
        bind(ITransactionRepository.class).to(TransactionRepository.class).in(Singleton.class);
        bind(ISaleRepository.class).to(SaleRepository.class);
    };
}
