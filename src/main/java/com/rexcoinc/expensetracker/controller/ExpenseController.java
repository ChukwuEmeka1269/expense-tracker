package com.rexcoinc.expensetracker.controller;

import com.rexcoinc.expensetracker.constants.AppConstants;
import com.rexcoinc.expensetracker.model.Expense;
import com.rexcoinc.expensetracker.service.ExpenseService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(AppConstants.EXPENSE)
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ExpenseController {

    ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<?> addExpense(@RequestBody Expense expense){
        expenseService.addExpense(expense);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    };

    @PutMapping("/{id}")
    public ResponseEntity<?> updateExpense(@RequestBody  Expense expense, @PathVariable String id){
        expenseService.updateExpense(expense, id);
        return ResponseEntity.status(HttpStatus.OK).build();
    };

    @GetMapping
    public ResponseEntity<?> getAllExpenses(){
        return ResponseEntity.status(HttpStatus.OK).body(expenseService.getAllExpenses());
    };

    @GetMapping("/{name}")
    public ResponseEntity<?> getExpenseByName(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body(expenseService.getExpenseByName(name));
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable String id){
        expenseService.deleteExpense(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    };
}
