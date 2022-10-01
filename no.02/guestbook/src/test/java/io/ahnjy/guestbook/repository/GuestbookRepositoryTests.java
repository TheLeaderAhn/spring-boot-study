package io.ahnjy.guestbook.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import io.ahnjy.guestbook.entity.Guestbook;
import io.ahnjy.guestbook.entity.QGuestbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
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
    @Transactional
    public void updateTest() {

        Optional<Guestbook> result = guestbookRepository.findById(1201L);

        if(result.isPresent()) {
            Guestbook guestbook = result.get();

            guestbook.changeTitle(("변경 제목 ........"));
            guestbook.changeContent("변경된 내용 확인......");

            guestbookRepository.save(guestbook);

        }

    }

    @Test
    public void testQuery1() {

        Pageable pageable =  PageRequest.of(0,10, Sort.by("gno").descending());
        QGuestbook qGuestbook = QGuestbook.guestbook; // 1
        String keyword = "1";

        BooleanBuilder builder = new BooleanBuilder(); //2

        BooleanExpression expression = qGuestbook.title.contains(keyword); //3

        builder.and(expression); //4

        Page<Guestbook> result = guestbookRepository.findAll(builder, pageable);

        result.stream().forEach(guestbook -> {
            System.out.println(guestbook);
        });


    }


    // 다중 항목 검색 테스트
    @Test
    public void testQuery2() {

        Pageable pageable = PageRequest.of(0,10, Sort.by("gno").descending());

        QGuestbook qGuestbook = QGuestbook.guestbook;

        String keyword = "1";

        BooleanBuilder builder = new BooleanBuilder();

        // 제목에 1 들어가는지
        BooleanExpression exTitle = qGuestbook.title.contains(keyword);

        // 내용에 1들어가는지
        BooleanExpression exContent = qGuestbook.content.contains(keyword);

        BooleanExpression exAll = exTitle.or(exContent);

        builder.and(exAll);

        builder.and(qGuestbook.gno.gt(0L));

        Page<Guestbook> result = guestbookRepository.findAll(builder, pageable);

        result.stream().forEach(guestbook -> {
            System.out.println(guestbook);
        });

    }

}
