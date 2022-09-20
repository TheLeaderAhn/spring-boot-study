package org.zerock.ex2.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.ex2.ebtity.Memo;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemoRepositoryTests {

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void testClass() {
        System.out.println("testClass():::::" + memoRepository.getClass().getName());
    }

    // 등록 작업 테스트
    @Test
    public void testInsertDummies() {

        // tbl_memo에 sample data 넣기
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Memo memo = Memo.builder().memoText("Sample..." + i).build();
            memoRepository.save(memo);
        });

    }

    //    조회 작업 테스트
    @Test
    public void testSelect() {

        // 데이이터 베이스에 존재하는 mno
        Long mno = 100L;
        Optional<Memo> result = memoRepository.findById(mno);

        System.out.println("========================================");

        if (result.isPresent()) {
            Memo memo = result.get();
            System.out.println("select Test ::::: " + memo);
        }

    }

    // @Transaction 방식 - getOne
    @Transactional
    @Test
    public void testSelect2() {

        Long mno = 100L;
        Optional<Memo> result = memoRepository.findById(mno);

        System.out.println("========================================");

        if (result.isPresent()) {
            Memo memo = result.get();
            System.out.println("select2() Test ::::: " + memo);
        }

    }

//    수정 작업 테스트

    @Test
    public void testUpdate() {
        Memo memo = Memo.builder().mno(100L).memoText("Update Text").build();
        System.out.println("testUpdate :::::::" + memoRepository.save(memo));
    }

    //    삭제 작업 테스트
    @Test
    public void testDelete() {
        Long mno = 100L;
        memoRepository.deleteById(mno);

    }

    // 페이징 처리
    @Test
    public void testPagedefault() {

        // 1패아자 10개
        Pageable pageable = PageRequest.of(0, 10);

        Page<Memo> result = memoRepository.findAll(pageable);

        System.out.println("Paging :::::" + result);
        System.out.println("-------------------------------------------");

        System.out.println("Total Pages : " + result.getTotalPages()); // 총 페이지

        System.out.println("Total Count : " + result.getTotalElements()); // 전체 개수

        System.out.println("Page Number : " + result.getNumber()); // 현재 페이지 번호

        System.out.println("Page Size : " + result.getSize()); // 페이지당 데이터 개수

        System.out.println("has next page :::: " + result.hasNext()); // 다음페이지 존재 여부

        System.out.println(" first page ? : " + result.isFirst()); // 시작페이지 (0) 여부

        System.out.println("-------------------------------------------");

        for (Memo memo : result.getContent()) {
            System.out.println(memo);
        }

    }

    // 페이지 정렬조건 추가
    @Test
    public void testSort() {

        Sort sort1 = Sort.by("mno").descending();
        Sort sort2 = Sort.by("memoText").ascending();
        Sort sortAll = sort1.and(sort2); // and 를 이용한 연결


//        Pageable pageable = PageRequest.of(0, 10, sort1);
        Pageable pageable = PageRequest.of(0, 10, sortAll);

        Page<Memo> result = memoRepository.findAll(pageable);

        result.get().forEach(memo -> {
            System.out.println(memo);
        });

    }

    // 쿼리 메서드 활용
    @Test
    public void testQueryMethods() {

        List<Memo> list = memoRepository.findByMnoBetweenOrderByMnoDesc(70L, 80L);

        for (Memo memo : list) {
            System.out.println(memo);
        }

    }

    // 쿼리 메서드와 Pageable 의 결합
    @Test
    public void testQueryMethodWithPageable(){

        Pageable pageable = PageRequest.of(0,10, Sort.by("mno").descending());

        Page<Memo> result = memoRepository.findByMnoBetween(10L, 50L, pageable);

        result.get().forEach(memo -> {
            System.out.println(memo);
        });

    }


//    deleteBy 로  시작하는 삭제처리
    @Commit
    @Transactional
    @Test
    public void testDeleteQueryMethos(){

        memoRepository.deleteMemoByMnoLessThan(10L);

    }



}






















