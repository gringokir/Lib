package library.service.impl;

import library.converter.CustomConversionService;
import library.dto.PurchaseDto;
import library.entity.Purchase;
import library.exception.PurchaseException;
import library.repository.PurchaseRepository;
import library.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final CustomConversionService conversionService;

    @Autowired
    public PurchaseServiceImpl(PurchaseRepository purchaseRepository, CustomConversionService conversionService) {
        this.purchaseRepository = purchaseRepository;
        this.conversionService = conversionService;
    }

    @Override
    public PurchaseDto getPurchaseById(Long id) {
        Purchase purchase = purchaseRepository.findById(id).orElseThrow(()-> new PurchaseException("Purchase not found"));
        return conversionService.convert(purchase, PurchaseDto.class);
    }

    @Override
    public List<PurchaseDto> getAll() {
        List<Purchase> purchaseList = purchaseRepository.findAll();
        return purchaseList
                .stream()
                .map(purchase -> conversionService.convert(purchase, PurchaseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PurchaseDto createPurchase(PurchaseDto purchaseDto) {
        Purchase purchase = conversionService.convert(purchaseDto, Purchase.class);
        return conversionService.convert(purchaseRepository.save(purchase), PurchaseDto.class);
    }

    @Override
    public PurchaseDto updatePurchase(PurchaseDto purchaseDto) {
        Purchase purchase = purchaseRepository.findById(purchaseDto.getPurchaseId()).orElseThrow(()-> new PurchaseException("Purchase not found"));
        return conversionService.convert(purchase, PurchaseDto.class);
    }

    @Override
    public void deletePurchase(Long id) {
        Purchase purchase = purchaseRepository.findById(id).orElseThrow(() -> new PurchaseException("Purchase is not found"));
        purchaseRepository.delete(purchase);
    }
}
