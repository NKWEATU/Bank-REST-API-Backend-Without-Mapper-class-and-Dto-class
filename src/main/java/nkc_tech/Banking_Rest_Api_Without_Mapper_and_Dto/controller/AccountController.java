package nkc_tech.Banking_Rest_Api_Without_Mapper_and_Dto.controller;

import nkc_tech.Banking_Rest_Api_Without_Mapper_and_Dto.entity.Account;
import nkc_tech.Banking_Rest_Api_Without_Mapper_and_Dto.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Create Account
    //http://localhost:8080/api/accounts
    @PostMapping
    public ResponseEntity<Account> addAccount(@RequestBody Account account){
        Account createdAccount = accountService.createAccount(account);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    // Get Account by ID
    //http://localhost:8080/api/accounts/1
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id){
        Account account = accountService.getAccountById(id);
        return ResponseEntity.ok(account);
    }

    // Deposit
    //http://localhost:8080/api/accounts/1/deposit
    @PutMapping("/{id}/deposit")
    public ResponseEntity<Account> deposit(@PathVariable Long id,
                                           @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
        Account account = accountService.deposit(id, amount);
        return ResponseEntity.ok(account);
    }

    // Withdraw
    //http://localhost:8080/api/accounts/1/withdraw
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<Account> withdraw(@PathVariable Long id,
                                            @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
        Account account = accountService.withdraw(id, amount);
        return ResponseEntity.ok(account);
    }

    // Get All Accounts
    //http://localhost:8080/api/accounts
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts(){
        List<Account> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    // Delete Account
    //http://localhost:8080/api/accounts/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted successfully!");
    }

}
