package io.ahnjy.guestbook.repository;

import io.ahnjy.guestbook.entity.Guestbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * description    :
 * packageName    : io.ahnjy.guestbook.repository
 * fileName       : GuestbookRepository
 * author         : ahnjy
 * date           : 2022/09/28
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/09/28        ahnjy       최초 생성
 */
public interface GuestbookRepository extends JpaRepository<Guestbook, Long> , QuerydslPredicateExecutor<Guestbook> {



}
