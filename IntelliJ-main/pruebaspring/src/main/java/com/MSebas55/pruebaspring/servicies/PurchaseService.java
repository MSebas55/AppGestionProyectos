package com.MSebas55.pruebaspring.servicies;

import com.MSebas55.pruebaspring.models.Purchase;
import com.MSebas55.pruebaspring.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;
    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }
    public Purchase getPurchaseById(Integer id) {
        Optional<Purchase> optionalPurchase = purchaseRepository.findById(id);
        return optionalPurchase.orElse(null);
    }
    public Purchase savePurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }
    public Boolean deletePurchase(Integer id) {
        purchaseRepository.deleteById(id);
        return purchaseRepository.findById(id).isEmpty();
    }
}
