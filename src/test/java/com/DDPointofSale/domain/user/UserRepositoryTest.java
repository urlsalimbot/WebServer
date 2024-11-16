package com.DDPointofSale.domain.user;

import com.DDPointofSale.Infrastructure.AppHibernate;
import com.DDPointofSale.domain.repository.UserRepository;
import org.junit.jupiter.api.Test;


class UserRepositoryTest {

    @Test
    void test(){
        AppHibernate hibernate = new AppHibernate();
        UserRepository userRepository = new UserRepository(hibernate);

        var list = userRepository.getAllUsers();
        System.out.println(list);
    }

}