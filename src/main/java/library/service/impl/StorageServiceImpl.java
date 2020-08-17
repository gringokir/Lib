package library.service.impl;

import library.converter.CustomConversionService;
import library.dto.StorageDto;
import library.entity.Storage;
import library.exception.StorageException;
import library.repository.StorageRepository;
import library.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StorageServiceImpl implements StorageService {
    private final StorageRepository storageRepository;
    private final CustomConversionService conversionService;

    @Autowired
    public StorageServiceImpl(StorageRepository storageRepository, CustomConversionService conversionService) {
        this.storageRepository = storageRepository;
        this.conversionService = conversionService;
    }

    @Override
    public StorageDto getStorageById(Long id) {
        Storage storage = storageRepository.findById(id).orElseThrow(() -> new StorageException("Storage is not found"));
        return conversionService.convert(storage, StorageDto.class);
    }

    @Override
    public List<StorageDto> getAll() {
        List<Storage> storageList = storageRepository.findAll();
        return storageList
                .stream()
                .map(storage -> conversionService.convert(storage, StorageDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public StorageDto createStorage(StorageDto storageDto) {
        Storage storage = conversionService.convert(storageDto, Storage.class);
        return conversionService.convert(storageRepository.save(storage), StorageDto.class);
    }

    @Override
    public StorageDto updateStorage(StorageDto storageDto) {
        Storage storage = storageRepository.findById(storageDto.getStorageId()).orElseThrow(() -> new StorageException("Storage is not found"));
        return conversionService.convert(storage, StorageDto.class);
    }

    public void deleteStorage(Long id){
        Storage storage = storageRepository.findById(id).orElseThrow(() -> new StorageException("Storage is not found"));
        storageRepository.delete(storage);
    }
}
