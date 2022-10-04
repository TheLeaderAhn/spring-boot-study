package io.ahnjy.ch5board.entity;

import lombok.*;

import javax.persistence.*;

/**
 * description    :
 * packageName    : io.ahnjy.ch5board.entity
 * fileName       : Board
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
@ToString(exclude = "writer")
public class Board extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 생성을 디비에 위임
    private Long bno;

    private String title;

    private String content;

    @ManyToOne
    private Member writer;

}
