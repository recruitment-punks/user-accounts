package com.bdsystems.useraccounts.accountbalance.service;

import com.bdsystems.useraccounts.accountbalance.infrastructure.UsersRepository;
import com.bdsystems.useraccounts.accountbalance.model.User;
import com.bdsystems.useraccounts.accountbalance.model.UserAccountBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountBalanceService {

    private UsersRepository repository;

    private CurrencyExchangeService currencyExchangeService;

    public AccountBalanceService(UsersRepository repository, CurrencyExchangeService currencyExchangeService) {
        this.repository = repository;
        this.currencyExchangeService = currencyExchangeService;
    }

    public List<UserAccountBalance>getAccountBalanceForUsers(){
        List<UserAccountBalance> userAccountBalances = new ArrayList<>();
        List<User> users = repository.getAllUsers();
        for (User user : users){
            userAccountBalances.add(prepareUserAccountBalance(user));
        }
        return userAccountBalances;
    }

    public UserAccountBalance getAccountBalanceForUser(int id) {
        Optional<User> user = repository.getUserById(id);
        if (user.isPresent()) {
            return prepareUserAccountBalance(user.get());
        } else {
            //Tu powinienem rzucić wyjątek który przechwyce i zwrócę w ResponseEntity
            return null;
        }
    }


    private UserAccountBalance prepareUserAccountBalance(User user)  {
        return UserAccountBalance.builder()
                .id(user.getId())
                .accountBalance(currencyExchangeService.recalculateToUsd(user.getAccountBalance()))
                .build();
    }
}
