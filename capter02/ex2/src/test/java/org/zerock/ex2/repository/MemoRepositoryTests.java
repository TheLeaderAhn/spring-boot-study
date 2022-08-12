package org.zerock.ex2.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.ex2.ebtity.Memo;

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

        if(result.isPresent()){
            Memo memo = result.get();
            System.out.println("select2() Test ::::: " + memo);
        }

    }

//    수정 작업 테스트

    @Test
    public void testUpdate(){
        Memo memo = Memo.builder().mno(100L).memoText("Update Text").build();
        System.out.println("testUpdate :::::::" + memoRepository.save(memo));
    }

//    삭제 작업 테스트
    @Test
    public void testDelete(){
        Long mno = 100L;
        memoRepository.deleteById(mno);

    }



}
