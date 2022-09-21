package com.ahnjy.chapter02.repository;

import com.ahnjy.chapter02.entity.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * description    :
 * packageName    : com.ahnjy.chapter02.repository
 * fileName       : MemoRepositoryTests
 * author         : ahnjy
 * date           : 2022/09/20
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/09/20        ahnjy       최초 생성
 */
@SpringBootTest
public class MemoRepositoryTests {

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void testClass() {
        System.out.println(memoRepository.getClass().getName());
    }

    /**
     * insertSample 데이터 사용
     *
     */

    @Test
    public void testInsertDummies() {

        IntStream.rangeClosed(1,100).forEach(i -> {
            Memo memo = Memo.builder().memoText("Sample..." + i).build();
            memoRepository.save(memo);
        });

    }


    /**
     * 조회 작업 테스트
     *
     *
     * */
    @Test
    public void testSelect() {

        //데이터 베이스 mno
        Long mno = 100L;

        Optional<Memo> result = memoRepository.findById(mno);

        System.out.println("::::::::::::::::::::::::::::::::");

        if(result.isPresent()) {
            Memo memo = result.get();
            System.out.println("memo : "+ memo);
        }
    }


    /**
     * getOne() 은 @Transaction 이 필요하다
     */
    @Transactional
    @Test
    public void testSelect2(){

        // 디비 mno
        Long mno = 99L;

        Memo memo = memoRepository.getOne(mno);

        System.out.println("::::::::::::::::::::::::::::::::::::::::");
        System.out.println("memo : " + memo);
    }

    /**
     * 수정 작업테스트 - insert 와 동일하게 save()구문 사용
     */
    @Test
    public void TestUpdate() {
        Memo memo = Memo.builder().mno(100L).memoText("Update Text Version").build();
        System.out.println(memoRepository.save(memo));
    }

    /**
     * 삭제 작업 테스트
     */

    @Test
    public void testDelete() {

        Long mno = 98L;

        memoRepository.deleteById(mno);


    }

    /**
     *
     * 페이징 처리
     * @since 2022.09.21
     */
    @Test
    public void testPageDefault() {

        // 1페이지 10개
        Pageable pageable = PageRequest.of(0,10);

        Page<Memo> result = memoRepository.findAll(pageable);
        System.out.println(result);

        System.out.println("--------------------------------------------------------------------");

        System.out.println("Total Pages : " + result.getTotalPages());      // 총 몇 페이지
        System.out.println("Total Count : " + result.getTotalElements());   // 전체 개수
        System.out.println("Page Number : " + result.getNumber());          // 현재 페이지 번호 0부터 시작
        System.out.println("Page Size : " + result.getSize());              // 페이지당
        System.out.println("Page hasNext : " + result.hasNext());           // 다음페이지 존재여부
        System.out.println("Page Size : " + result.isFirst());              // 시작 페이지 여부

        System.out.println("--------------------------------------------------------------------");

        for(Memo memo : result.getContent()) {
            System.out.println(memo);
        }
    }


    /**
     * 정렬 조건 추가하기
     */
    @Test
    public void testsort() {

        Sort sort1 = Sort.by("mno").descending();
        Sort sort2 = Sort.by("memoText").ascending();
        Sort sortAll = sort1.and(sort2);

        Pageable pageable = PageRequest.of(0, 10, sort1);

        Page<Memo> result = memoRepository.findAll(pageable);

        result.get().forEach(memo -> {
            System.out.println(memo);
        });

    }


    /**
     * 쿼리 메서드
     */
/*    @Test
    public void testQueryMethods() {

        List<?> mlist = memoRepository.findByBetweenOderByMnoDesc(30L, 40L);

        for (Object memo : mlist) {
            System.out.println(memo);
        }
    }*/


    // 쿼리 메서드와 pageable 결합
    @Test
    public void testQueryMethodWithPageable(){

        Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending());

        Page<Memo> result = memoRepository.findByMnoBetween(10L, 50L, pageable);

        result.get().forEach(memo -> System.out.println(memo));

    }


}
