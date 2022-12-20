package com.rexcoinc.expensetracker.service;

import com.rexcoinc.expensetracker.model.Expense;
import com.rexcoinc.expensetracker.repository.ExpenseRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class ExpenseService {

    ExpenseRepository expenseRepository;


    public void addExpense(Expense expense){
        expenseRepository.save(expense);
    };

    public void updateExpense(Expense expense, String id){
        Expense savedExpense = expenseRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(String.format("Expense with id: %s not found", id)));


        savedExpense.setExpenseAmount(expense.getExpenseAmount());
        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());
        savedExpense.setId(expense.getId());

        expenseRepository.save(savedExpense);
    };

    public List<Expense> getAllExpenses(){
        return  expenseRepository.findAll();
    };

    public Expense getExpenseByName(String name){
       return expenseRepository.findByName(name)
                .orElseThrow(()-> new RuntimeException(String.format("Expense with name %s not found", name)));
    };

    public void deleteExpense(String id){
        expenseRepository.deleteById(id);
    };
}
