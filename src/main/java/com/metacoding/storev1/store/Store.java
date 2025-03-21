package com.metacoding.storev1.store;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // JPA가 필드 값에 접근하기 위해 필요함
@NoArgsConstructor // JPA가 ObjectMapping을 위해 new할 때 사용
                   // 리플렉션할 때 초반에 클래스를 생성해야하는데 기본생성자가 없으면 생성 불가하기 때문.
@Table(name = "store_tb") // 테이블명 설정
@Entity // 이 클래스가 DB 테이블과 매핑된 엔티티임을 나타냄 -> JPA에게 알려줌
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name; // 상품 이름
    private Integer stock; // 상품 개수
    private Integer price; // 상품 가격

    public void 재고감소(int qty) {
        this.stock = this.stock - qty;
    }
}
