package com.ahnjy.chapter02.repository;

import com.ahnjy.chapter02.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * description    :
 * packageName    : com.ahnjy.chapter02.repository
 * fileName       : MemoRepository
 * author         : ahnjy
 * date           : 2022/09/20
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/09/20        ahnjy       최초 생성
 */
public interface MemoRepository extends JpaRepository<Memo, Long> {
}
