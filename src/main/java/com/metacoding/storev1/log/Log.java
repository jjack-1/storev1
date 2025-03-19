package com.metacoding.storev1.log;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // JPA가 ObjectMapping을 위해 new할 때 사용
                   // 리플렉션할 때 초반에 클래스를 생성해야하는데 기본생성자가 없으면 생성 불가하기 때문.
@Table(name = "log_tb") // 테이블명 설정
@Entity // 이 클래스가 DB 테이블과 매핑된 엔티티임을 나타냄
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer storeId; // 상품 ID (FK)
    private String qty; // 구매 개수
    private Integer totalPrice; // qty * store(price)
    private String buyer; // 구매자 이름
}
