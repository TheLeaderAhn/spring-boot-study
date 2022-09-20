package com.ahnjy.chapter02.entity;

import lombok.*;

import javax.persistence.*;

/**
 * description    :
 * packageName    : com.ahnjy.chapter02.entity
 * fileName       : Memo
 * author         : ahnjy
 * date           : 2022/09/20
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/09/20        ahnjy       최초 생성
 */
@Entity
@Table(name="tbl_memo")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    @Column(length = 200, nullable = false)
    private String memoText;

}
