package com.metacoding.storev1.store;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

// @RequiredArgsConstructor // final 이 붙은 필드로만 생성자 만들어
@Repository
public class StoreRepository {

    private final EntityManager em;

    public StoreRepository(EntityManager em) {
        this.em = em;
    }

    public void save(String name, int stock, int price) {
        Query query = em.createNativeQuery("insert into store_tb (name, stock ,price) values (?, ?, ?)");
        query.setParameter(1, name);
        query.setParameter(2, stock);
        query.setParameter(3, price);
        query.executeUpdate();
    }

    // List<Store> -> 모델
    public List<Store> findAll() {
        // 조건 : 오브젝트 매핑은 @Entity가 붙어야지만 가능하다(디폴트생성자 호출)
        Query query = em.createNativeQuery("select * from store_tb order by id desc", Store.class);
        return query.getResultList();
    }

    public Store findById(int id) {
        // 조건 : 오브젝트 매핑은 @Entity가 붙어야지만 가능하다(디폴트생성자 호출)
        Query query = em.createNativeQuery("select * from store_tb where id = ?", Store.class);
        query.setParameter(1, id);
        return (Store) query.getSingleResult();
    }

    public void deleteById(int id) {
        Query query = em.createNativeQuery("delete from store_tb where id = ?", Store.class);
        query.setParameter(1, id);
        query.executeUpdate();
    }

    // TODO #1 id를 기준으로 업데이트 쿼리 작성
    public void updateById(int id, String name, int stock, int price) {
        Query query = em.createNativeQuery("update store_tb set name = ?, stock = ?, price = ? where id = ?");
        query.setParameter(1, name);
        query.setParameter(2, stock);
        query.setParameter(3, price);
        query.setParameter(4, id);
        query.executeUpdate();
    }
}
