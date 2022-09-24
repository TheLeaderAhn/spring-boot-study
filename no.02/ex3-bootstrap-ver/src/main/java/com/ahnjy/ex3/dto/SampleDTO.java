package com.ahnjy.ex3.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * description    :
 * packageName    : com.ahnjy.ex3.dto
 * fileName       : SampleDTO
 * author         : ahnjy
 * date           : 2022/09/21
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/09/21        ahnjy       최초 생성
 */
@Data
@Builder(toBuilder = true)
public class SampleDTO {

    private Long sno;

    private String first;

    private String last;

    private LocalDateTime regTime;

}
