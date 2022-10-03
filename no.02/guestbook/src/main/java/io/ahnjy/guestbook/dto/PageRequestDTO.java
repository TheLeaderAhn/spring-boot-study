package io.ahnjy.guestbook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * description    :
 * packageName    : io.ahnjy.guestbook.dto
 * fileName       : PageRequestDTO
 * author         : ahnjy
 * date           : 2022/10/02
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/02        ahnjy       최초 생성
 */
@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO {

    private int page;

    private int size;

    //기본 설정
    public PageRequestDTO() {
        this.page = 1;
        this.size = 10;
    }

    // JPA 를 이용한경우 페이지 번호가 0부터 시작 함 ... -1 해준다
    public Pageable getPageable(Sort sort){

        return PageRequest.of(page -1, size, sort);
    }

}
