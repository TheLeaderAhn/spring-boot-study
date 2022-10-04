package io.ahnjy.ch5board.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * description    :
 * packageName    : io.ahnjy.ch5board.entity
 * fileName       : Member
 * author         : ahnjy
 * date           : 2022/10/04
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/04        ahnjy       최초 생성
 */
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Member extends BaseEntity {

    @Id
    private String email;

    private String password;

    private String name;

}
