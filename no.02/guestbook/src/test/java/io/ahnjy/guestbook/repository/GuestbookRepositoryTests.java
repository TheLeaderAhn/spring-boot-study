package io.ahnjy.guestbook.repository;

import io.ahnjy.guestbook.entity.Guestbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;
import java.util.Optional;
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


    // 300개 데이터 밀어 넣기
    @Test
    public void insertDummies() {

            IntStream.rangeClosed(1,300).forEach(i -> {

                Guestbook guestbook = Guestbook.builder()
                        .title("제목 [ " +  i + " ]")
                        .content("내용..."+i)
                        .writer("user" + (i % 10))
                        .build();
                System.out.println(guestbookRepository.save(guestbook));
            });


    }

    @Test
    public void updateTest() {

        Optional<Guestbook> result = guestbookRepository.findById(300L);

        if(result.isPresent()) {
            Guestbook guestbook = result.get();

            guestbook.changeTitle(("변경 제목 ........"));
            guestbook.changeContent("변경된 내용 확인......");

            guestbookRepository.save(guestbook);

        }

    }

}
