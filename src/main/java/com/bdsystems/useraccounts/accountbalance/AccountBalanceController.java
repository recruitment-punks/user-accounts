package com.bdsystems.useraccounts.accountbalance;

import com.bdsystems.useraccounts.accountbalance.model.UserAccountBalance;
import com.bdsystems.useraccounts.accountbalance.service.AccountBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accountBalance/users")
public class AccountBalanceController {

    private AccountBalanceService accountBalanceService;

    AccountBalanceController(AccountBalanceService accountBalanceService){
        this.accountBalanceService = accountBalanceService;
    }

    //W obu przypadkach zamiast listy z specyficznym DTO mógłbym to opakować w ResponseEntity
    @GetMapping("/")
    public List<UserAccountBalance> getAllUsersBalance() {
        return accountBalanceService.getAccountBalanceForUsers();
    }

    @GetMapping("/{id}")
    public UserAccountBalance getSpecifiedUsersBalance(@PathVariable int id) {
        return accountBalanceService.getAccountBalanceForUser(id);
    }
}
