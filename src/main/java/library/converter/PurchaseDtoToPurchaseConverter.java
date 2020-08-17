package library.converter;

import library.dto.PurchaseDto;
import library.entity.Book;
import library.entity.Person;
import library.entity.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PurchaseDtoToPurchaseConverter implements Converter<PurchaseDto, Purchase> {
    private final CustomConversionService conversionService;

    @Autowired
    public PurchaseDtoToPurchaseConverter(CustomConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public Purchase convert(PurchaseDto purchaseDto) {
        Purchase purchase = new Purchase();
        purchase.setId(purchaseDto.getPurchaseId());
        purchase.setReturnDate(purchaseDto.getReturnDate());
        purchase.setBooks(conversionService.convert(purchaseDto.getBooks(), Book.class));
        return purchase;
    }
}
