package library.converter;

import library.dto.StorageDto;
import library.entity.Book;
import library.entity.Person;
import library.entity.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class StorageDtoToStorageConverter implements Converter<StorageDto, Storage> {
    private final CustomConversionService conversionService;

    @Autowired
    public StorageDtoToStorageConverter(CustomConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public Storage convert(StorageDto storageDto) {
        Storage storage = new Storage();
        storage.setId(storageDto.getStorageId());
        storage.setAvailableBooks(conversionService.convert(storageDto.getAvailableBooks(), Book.class));
        storage.setCustomers(conversionService.convert(storageDto.getCustomers(), Person.class));
        return storage;
    }
}
