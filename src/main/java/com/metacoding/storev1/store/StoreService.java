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
        // try {
        // } catch (Exception e) {
        // throw new RuntimeException("해당 상품이 없어 상세보기가 불가합니다");
        // }
    }

    @Transactional
    public void 상품삭제(int id) {
        try {
            storeRepository.findById(id);
            storeRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("해당 상품이 없어 삭제가 불가합니다");
        }
    }

    @Transactional
    public void 상품업데이트(int id, String name, int stock, int price) {
        try {
            storeRepository.findById(id);
            storeRepository.updateById(id, name, stock, price);
        } catch (Exception e) {
            throw new RuntimeException("해당 상품이 없어 업데이트가 불가합니다");
        }
    }
}
