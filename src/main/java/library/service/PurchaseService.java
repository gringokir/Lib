package library.service;

import library.dto.PurchaseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PurchaseService {
    PurchaseDto getPurchaseById(Long id);

    List<PurchaseDto> getAll();

    PurchaseDto createPurchase(PurchaseDto purchaseDto);

    PurchaseDto updatePurchase(PurchaseDto purchaseDto);

    void deletePurchase(Long id);
}
