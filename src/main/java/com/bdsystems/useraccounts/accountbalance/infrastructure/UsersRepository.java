package com.bdsystems.useraccounts.accountbalance.infrastructure;

import com.bdsystems.useraccounts.accountbalance.model.User;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UsersRepository {

    private static final List<User> mockedDatabaseUsers = initUserList();

    private static List<User> initUserList() {
        return new ArrayList<>(){{
            add(new User(1,"Paweł",new BigDecimal(77)));
            add(new User(2,"Karol",new BigDecimal(100)));
            add(new User(3,"Maciek",new BigDecimal(120)));
        }};
    }

    public List<User> getAllUsers() {
        return mockedDatabaseUsers;
    }

    public Optional<User> getUserById(int id) {
        for(User user : mockedDatabaseUsers) {
            if(user.getId()==id)
                return Optional.of(user);
        }
        return Optional.empty();
    }
}
