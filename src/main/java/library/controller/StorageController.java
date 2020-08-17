package library.controller;

import library.dto.StorageDto;
import library.service.StorageService;
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
@RequestMapping("/storage")
public class StorageController {
    private final StorageService storageService;

    @Autowired
    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping
    @RequestMapping("/{id}")
    public StorageDto getStorageById(@PathVariable Long id){
        return storageService.getStorageById(id);
    }

    @GetMapping
    public List<StorageDto> getAll(){
        return storageService.getAll();
    }

    @PostMapping
    @RequestMapping("/create")
    public StorageDto createStorage(StorageDto storageDto){
        return storageService.createStorage(storageDto);
    }

    @PutMapping
    @RequestMapping("/update/")
    public StorageDto updateStorage(StorageDto storageDto) {
        return storageService.updateStorage(storageDto);
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public void deleteStorage(@PathVariable Long id){
        storageService.deleteStorage(id);
    }
}
