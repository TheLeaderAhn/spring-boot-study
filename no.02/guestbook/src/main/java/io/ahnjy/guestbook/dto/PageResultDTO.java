package io.ahnjy.guestbook.dto;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * description    :
 * packageName    : io.ahnjy.guestbook.dto
 * fileName       : PageResultDTO
 * author         : ahnjy
 * date           : 2022/10/02
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/02        ahnjy       최초 생성
 */
@Data
public class PageResultDTO<DTO, EN> {

    // DTO 목록
    private List<DTO> dtoList;

    // 총 페이지 번호
    private int totalPage;

    // 현재 페이지 번호
    private int page;

    // 목록 사이즈
    private int size;

    //시작 페이지 끝 페이지
    private int start, end;

    // 이전 , 다음
    private boolean prev, next;

    // 페이지 번호 목록
    private List<Integer> pageList;

    public PageResultDTO(Page<EN> result, Function<EN,DTO> fn) {

        dtoList = result.stream().map(fn).collect(Collectors.toList());

        totalPage = result.getTotalPages();

        makePageList(result.getPageable());

    }

    private void makePageList(Pageable pageable){

        this.page = pageable.getPageNumber() +1; // 0부터 시작하므로 1추가
        this.size = pageable.getPageSize();

        // temp end Page
        int tempEnd = (int)(Math.ceil(page/10.0)) * 10; // 10,20, 30...

        start = tempEnd - 9; // 페이지 사이즈 10일경우

        prev = start > 1; // 1페이지면 이전 노출 안함

        end = totalPage > tempEnd ?  tempEnd : totalPage; // 34페이지 가 마지막인데 40페이지 노출 안시킬경우

        next = totalPage > tempEnd;

        pageList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());





    }



}
