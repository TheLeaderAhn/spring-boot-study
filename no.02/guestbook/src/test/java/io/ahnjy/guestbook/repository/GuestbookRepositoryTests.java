package io.ahnjy.guestbook.repository;

import io.ahnjy.guestbook.entity.Guestbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

/**
 * description    :
 * packageName    : io.ahnjy.guestbook.repository
 * fileName       : GuestbookRepositoryTests
 * author         : ahnjy
 * date           : 2022/09/28
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/09/28        ahnjy       최초 생성
 */
@SpringBootTest
public class GuestbookRepositoryTests {

    @Autowired
    private GuestbookRepository guestbookRepository;


    // IntStream 공부
    @Test
    public void for_loop() {
        for(int i =1; i<=10; i++){
            System.out.println(i);
        }
    }

    @Test
    public void intStream_range() {
        IntStream.range(1,11).forEach(System.out::println);
    }

    @Test
    public void intStream_rangeClosed() {
        IntStream.rangeClosed(1,10).forEach(System.out::println);
    }

}
