package io.ahnjy.ch5board.repository;

import io.ahnjy.ch5board.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * description    :
 * packageName    : io.ahnjy.ch5board.repository
 * fileName       : ReplyRepository
 * author         : ahnjy
 * date           : 2022/10/04
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/04        ahnjy       최초 생성
 */
public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
