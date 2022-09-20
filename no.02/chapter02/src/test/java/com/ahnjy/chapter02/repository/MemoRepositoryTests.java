package com.ahnjy.chapter02.repository;

import com.ahnjy.chapter02.entity.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
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




}
