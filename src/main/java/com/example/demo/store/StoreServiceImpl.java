package com.example.demo.store;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    @Override
    public void save(Store store) {
        // id 는 자동 생성 null
        Store store1 =
                new Store(null, "name", "addr");
        storeRepository.save(store1); // insert
        log.info("store1 id : {}", store1.getId()); // id : 1
    }
    static int i = 0;
/*
    Entity 매니저에 찾아온 값을 등록 해놓고
    Entity 조회해서 없다면 실제 디비를 찾는다.
    있으면 Entity 매니저가 바로 리턴해준다
    즉 db를 부하를 줄일 수 있다.
    Entity 매니저의 생명주기는 트랜젝션 이 맺어지고 소멸 까지이다.
    jpa 왜 쓰나요
    Entity 매니저를 통해 db를 부하를 줄일 수 있다
*/
    @Override
    public void update(Store store) {
        Store store1 =
                new Store(1L, "update" + i++, "update");
        storeRepository.save(store1); // insert 와 update 같이 해줌
//      아이디 있는지 찾아보고 있으면 update 를 해주고 없으면 insert 해줌
    }
}
