package com.MSebas55.pruebaspring.controllers;

import com.MSebas55.pruebaspring.models.Purchase;
import com.MSebas55.pruebaspring.servicies.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;
    @GetMapping("/all")
    public List<Purchase> getAllPurchases() {
        return purchaseService.getAllPurchases();
    }

    @GetMapping("/by-id/{id}")
    public Purchase getPurchaseById(@PathVariable Integer id) {
        return purchaseService.getPurchaseById(id);
    }

    @PostMapping("/save")
    public Purchase savePurchase(@RequestBody Purchase purchase) {
        return purchaseService.savePurchase(purchase);
    }
    @PutMapping("/update")
    public Purchase updatePurchase(@RequestBody Purchase purchase) {
        return purchaseService.savePurchase(purchase);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deletePurchase(@PathVariable Integer id) {
        return purchaseService.deletePurchase(id);
    }
}
