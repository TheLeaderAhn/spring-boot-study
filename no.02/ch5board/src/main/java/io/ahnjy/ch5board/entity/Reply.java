package io.ahnjy.ch5board.entity;

import lombok.*;

import javax.persistence.*;

/**
 * description    :
 * packageName    : io.ahnjy.ch5board.entity
 * fileName       : Reply
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
@ToString(exclude = "board")
public class Reply extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    private String text;

    private String replyer;

    @ManyToOne
    private Board board;

}
