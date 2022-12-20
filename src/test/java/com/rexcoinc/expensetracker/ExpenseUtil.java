package com.rexcoinc.expensetracker;

import com.rexcoinc.expensetracker.model.Expense;
import com.rexcoinc.expensetracker.model.ExpenseCategory;

import java.math.BigDecimal;

public class ExpenseUtil {

    public static Expense createExpense(){
        Expense expense = new Expense();
        expense.setExpenseCategory(ExpenseCategory.ENTERTAINMENT);
        expense.setExpenseName("Movie Night");
        expense.setExpenseAmount(BigDecimal.valueOf(2000));
        expense.setId("ENT101");

        return expense;
    }


}
