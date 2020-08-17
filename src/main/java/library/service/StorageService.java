package library.service;

import library.dto.StorageDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StorageService {

    StorageDto getStorageById(Long id);

    List<StorageDto> getAll();

    StorageDto createStorage(StorageDto storageDto);

    StorageDto updateStorage(StorageDto storageDto);

    void deleteStorage(Long id);
}
