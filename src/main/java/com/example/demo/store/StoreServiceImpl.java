package com.example.demo.store;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/*
    Entity 매니저에 찾아온 값을 등록 해놓고
    Entity 조회해서 없다면 실제 디비를 찾는다.
    있으면 Entity 매니저가 바로 리턴해준다
    즉 db를 부하를 줄일 수 있다.
    Entity 매니저의 생명주기는 트랜젝션 이 맺어지고 소멸 까지이다.
    jpa 왜 쓰나요
    Entity 매니저를 통해 db를 부하를 줄일 수 있다
*/
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
        return storeRepository.findById(id)
                .orElseThrow();
    }
    @Override
    @Transactional // 에러 rollback return commit dirty checking
    public Store update(Long id, Store store) {
        Store store1 = getById(id);
        store1.setAddress(store.getAddress());
        store1.setName(store.getName());
//        storeRepository.save(store1); // insert, update
        return store1;
    }



    @Override
    public List<Store> getByContainName(String name) {
        return storeRepository.findByNameContain(name);
    }
}
