package com.metacoding.storev1.store;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoreService {

    private StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Transactional
    public void 상품등록(String name, int stock, int price) {
        storeRepository.save(name, stock, price);
    }

    public List<Store> 상품목록() {
        List<Store> storeList = storeRepository.findAll();
        return storeList;
    }

    public Store 상품상세보기(int id) {
        return storeRepository.findById(id);
    }

    @Transactional
    public void 상품삭제(int id) {
        Store store = storeRepository.findById(id);

        if (store == null)
            throw new RuntimeException("해당 id의 데이터가 없습니다");
        else
            storeRepository.deleteById(id);
    }

    // TODO #3 상품데이터 업데이트 로직
    @Transactional
    public void 상품업데이트(int id, String name, int stock, int price) {
        // 1. 해당 상품 있는지 확인
        Store store = storeRepository.findById(id);

        // 2. 있으면 업데이트 없으면 에러
        if (store == null)
            throw new RuntimeException("해당 id의 데이터가 없습니다");
        else
            storeRepository.updateById(id, name, stock, price);
    }

}
