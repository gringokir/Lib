package library.converter;

import library.dto.BookDto;
import library.dto.PersonDto;
import library.dto.PurchaseDto;
import library.entity.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PurchaseToPurchaseDtoConverter implements Converter<Purchase, PurchaseDto> {
    private final CustomConversionService conversionService;

    @Autowired
    public PurchaseToPurchaseDtoConverter(CustomConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public PurchaseDto convert(Purchase purchase) {
        PurchaseDto purchaseDto = new PurchaseDto();
        purchaseDto.setPurchaseId(purchase.getId());
        purchaseDto.setReturnDate(purchase.getReturnDate());
        purchaseDto.setBooks(conversionService.convert(purchase.getBooks(), BookDto.class));
        return purchaseDto;
    }
}
