package io.ahnjy.guestbook.entity;

import lombok.*;

import javax.persistence.*;

/**
 * description    :
 * packageName    : io.ahnjy.guestbook.entity
 * fileName       : Guestbook
 * author         : ahnjy
 * date           : 2022/09/28
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/09/28        ahnjy       최초 생성
 */
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Guestbook  extends  BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gno;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length =  1500, nullable = false)
    private String content;

    @Column(length = 50, nullable = false)
    private String writer;

}