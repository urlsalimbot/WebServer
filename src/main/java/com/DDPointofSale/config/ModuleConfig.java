package com.DDPointofSale.config;

import com.DDPointofSale.Infrastructure.AppHibernate;
import com.DDPointofSale.domain.repository.CategoryRepository;
import com.DDPointofSale.domain.service.CategoryService;
import com.DDPointofSale.domain.repository.interfaces.ICategoryRepository;
import com.DDPointofSale.domain.repository.interfaces.IProductRepository;
import com.DDPointofSale.domain.repository.ProductRepository;
import com.DDPointofSale.domain.service.ProductService;
import com.DDPointofSale.domain.repository.interfaces.ITransactionRepository;
import com.DDPointofSale.domain.repository.TransactionRepository;
import com.DDPointofSale.domain.service.TransactionService;
import com.DDPointofSale.domain.repository.interfaces.IUserRepository;
import com.DDPointofSale.domain.repository.UserRepository;
import com.DDPointofSale.domain.service.UserService;
import com.DDPointofSale.security.userauth.AuthenticationRepository;
import com.DDPointofSale.security.userauth.AuthenticationService;
import com.DDPointofSale.security.userauth.IAuthenticationRepository;
import com.google.inject.AbstractModule;
import jakarta.inject.Singleton;

public class ModuleConfig extends AbstractModule {

    @Override
    protected void configure() {
        bind(UserService.class);
        bind(IUserRepository.class).to(UserRepository.class).in(Singleton.class);

        bind(CategoryService.class);
        bind(ICategoryRepository.class).to(CategoryRepository.class).in(Singleton.class);

        bind(ProductService.class);
        bind(IProductRepository.class).to(ProductRepository.class).in(Singleton.class);

        bind(TransactionService.class);
        bind(ITransactionRepository.class).to(TransactionRepository.class).in(Singleton.class);

        bind(AuthenticationService.class);
        bind(IAuthenticationRepository.class).to(AuthenticationRepository.class).in(Singleton.class);


        bind(AppHibernate.class).in(Singleton.class);


    };
}
