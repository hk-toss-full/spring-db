package com.example.demo.store;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    @Override
    public Store save(Store store) {
        return storeRepository.save(store);
    }
    @Override
    public List<Store> getAll() {
        return storeRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        storeRepository.deleteById(id);
    }
    @Override
    public Store getById(Long id) {
//        select * from tbl where id = ?
        return storeRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public List<Store> getByContainName(String name) {
        return List.of();
    }

    @Override
    public Store update(Long id, Store store) {
        return null;
    }


}
