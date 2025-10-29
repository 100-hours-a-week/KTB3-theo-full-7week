package com.example.KTB_7WEEK.user.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @SpringBootTest 스프링 부트 어플리케이션 전체를 실행한 뒤 통합 테스트 할 수 있도록 지원하는 어노테이션
 * 실제 스프링 컨텍스트를 로딩하기 때문에, 빈 등록, 의존성 주입 등이 실제 구동 환경과 동일하게 동작
 * @Transactional 테스트 메소드가 실행될 때 트랜잭션을 적용하는 어노테이션
 * 테스트 종료 후 기본적으로 롤백되어 DB에 변화가 남지 않도록 한다.
 */
@SpringBootTest
@Transactional
class UserTest {

    // JPA에서 EntityManager를 스프링 컨테이너로부터 주입받기 위해 사용하는 어노테이션
    @PersistenceContext
    EntityManager em; // @PersistenceContext로 주입받은 em은 프록시다.

    @Test // JUnit이 테스트 메소드로 인식하게 하는 어노테이션
    @Rollback(value = false)
    void idTest() {
        User user = new User.Builder()
                .email("email")
                .password("password")
                .nickname("nickname")
                .profileImage("profile_Image")
                .build();
        em.persist(user);
    }

    @Test
    @Rollback(value = false)
    void isStrategyTest() {
        // 5개 더미데이터 추가
        for (int i = 0; i < 5; i++) {
            User user = new User.Builder()
                    .email("email" + i)
                    .password("password")
                    .nickname("nickname" + i)
                    .profileImage("profile_Image" + i)
                    .build();
            em.persist(user);
        }
    }

    @Test
    @Rollback(false)
    void transactionTest() {
        em.clear();
        for (int i=0; i<5; i++) {
            User user = new User.Builder()
                    .email("email"+ i)
                    .password("password"+ i)
                    .nickname("nickname"+ i)
                    .profileImage("profile_Image"+ i)
                    .build();
            em.persist(user); // 해도 안 나간다. 기본 키 생성 전략이 Identify만 아니면
            System.out.println("User 넣기 : " + i);
        }
        for (int i=5; i<10; i++) {
            User user = new User.Builder()
                    .email("email" + i)
                    .password("password"+ i)
                    .nickname("nickname"+ i)
                    .profileImage("profile_Image"+ i)
                    .build();
            em.persist(user); // 해도 안 나간다. 기본 키 생성 전략이 Identify만 아니면
            System.out.println("User 넣기 : " + i);
        }
    }

    @Test
    void findTest() {
        User u = em.find(User.class, 1L); // 조회하는 순간 영속성 컨텍스트에 들어온다.
        User u2 = em.find(User.class, 1L); // 얘는 DB 조회가 아니라 영속성 컨텍스트의 값을 읽어온다.
        User u3 = em.find(User.class, 1L);
        System.out.println(u2==u3); // 객체 주소값 비교
    }

    @Test
    void bulkTest() { // 블로그 써야징
        long start = System.currentTimeMillis();
        for (int i=0; i<100000; i++) {
            User user = new User.Builder()
                    .email("email"+ i)
                    .password("password"+ i)
                    .nickname("nickname"+ i)
                    .profileImage("profile_Image"+ i)
                    .build();
            em.persist(user); // 해도 안 나간다. 기본 키 생성 전략이 Identify만 아니면
            System.out.println("User 넣기 : " + i);
        }
        System.out.println((double)(System.currentTimeMillis() - start) / 1000 + "초");
    }
}