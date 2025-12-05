package com.revature.ExpenseReport.Controllers;

import com.revature.ExpenseReport.Services.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
// controller talks to service
public class ExpenseController {
    // Fields
    private final ExpenseService service;

    // Constructor
    public ExpenseController(ExpenseService service){
        this.service = service;
    }

    // Methods
    @GetMapping
    public List<ExpenseDTO> getAllExpenses(){
        return service.getAllExpenses();
    }

    @GetMapping("/search")
    public List<ExpenseDTO> search(@RequestParam String merchant) {
        return service.searchByExpenseMerchant(merchant);
    }

    // user creates without id, which we generate
    @PostMapping
    public ExpenseDTO create(@RequestBody ExpenseWOIDDTO expenseDTO){
        return service.create(expenseDTO);
    }

    @GetMapping("/{id}")
    public ExpenseDTO getById(@PathVariable String id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public ExpenseDTO update(@PathVariable String id, @RequestBody ExpenseDTO dto){
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

}
