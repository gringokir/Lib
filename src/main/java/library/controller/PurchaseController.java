package library.controller;

import library.dto.PurchaseDto;
import library.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    @RequestMapping("/{id}")
    public PurchaseDto getPurchaseById(@PathVariable Long id){
        return purchaseService.getPurchaseById(id);
    }

    @GetMapping
    public List<PurchaseDto> getAll(){
        return purchaseService.getAll();
    }

    @PostMapping
    @RequestMapping("/create")
    public PurchaseDto createPurchase(PurchaseDto purchaseDto){
        return purchaseService.createPurchase(purchaseDto);
    }

    @PutMapping
    @RequestMapping("/update/")
    public PurchaseDto updatePurchase(PurchaseDto purchaseDto) {
        return purchaseService.updatePurchase(purchaseDto);
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public void deletePurchase(@PathVariable Long id){
        purchaseService.deletePurchase(id);
    }
}
