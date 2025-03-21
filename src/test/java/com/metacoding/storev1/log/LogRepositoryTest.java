package com.metacoding.storev1.log;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import com.metacoding.storev1.log.LogResponse.ListPage;

@Import(LogRepository.class) // LogRepository를 IoC에 등록
@DataJpaTest // em을 IoC 등록
public class LogRepositoryTest {

    @Autowired // IoC에 있는 것을 DI 한것임
    private LogRepository logRepository;

    @Test // 실행할 수 있는 세모버튼 생성
    public void findAllJoinStore_test() { // 매개변수에 아무것도 적을 수 없다.
        List<LogResponse.ListPage> logList = logRepository.findAllJoinStore();
        for (ListPage listPage : logList) {
            System.out.println(listPage);
        }
    }
}
