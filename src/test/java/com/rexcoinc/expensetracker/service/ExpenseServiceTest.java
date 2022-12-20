package com.rexcoinc.expensetracker.service;

import com.rexcoinc.expensetracker.ExpenseUtil;
import com.rexcoinc.expensetracker.model.Expense;
import com.rexcoinc.expensetracker.repository.ExpenseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExpenseServiceTest {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Test
    void givenAValidExpenseShouldSave() {
        //given
        Expense expense = ExpenseUtil.createExpense();

        //when
        Expense result = expenseRepository.save(expense);

        //then
        assertThat(expense).isEqualTo(result);

    }

    @Test
    void updateExpense() {
    }

    @Test
    void getAllExpenses() {
    }

    @Test
    void getExpenseByName() {
    }

    @Test
    void deleteExpense() {
    }
}