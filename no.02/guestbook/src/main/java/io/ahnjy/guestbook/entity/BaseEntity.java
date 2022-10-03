package io.ahnjy.guestbook.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * description    : 엔티티 객체의 등록시간과 최종수정시간을 담당
 * packageName    : io.ahnjy.guestbook.entity
 * fileName       : BaseEntity
 * author         : ahnjy
 * date           : 2022/09/24
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/09/24        ahnjy       최초 생성
 */
@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
abstract class BaseEntity {

    @CreatedDate
    @Column(name = "regdate", updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column(name ="moddate" )
    private LocalDateTime modDate;

}
