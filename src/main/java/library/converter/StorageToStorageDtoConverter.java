package library.converter;

import library.dto.BookDto;
import library.dto.PersonDto;
import library.dto.StorageDto;
import library.entity.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class StorageToStorageDtoConverter implements Converter<Storage, StorageDto> {
    private final CustomConversionService conversionService;

    @Autowired
    public StorageToStorageDtoConverter(CustomConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public StorageDto convert(Storage storage) {
        StorageDto storageDto = new StorageDto();
        storageDto.setStorageId(storage.getId());
        storageDto.setAvailableBooks(conversionService.convert(storage.getAvailableBooks(), BookDto.class));
        storageDto.setCustomers(conversionService.convert(storage.getCustomers(), PersonDto.class));
        return storageDto;
    }
}


