package io.ahnjy.guestbook.service;

import io.ahnjy.guestbook.dto.GuestbookDTO;
import io.ahnjy.guestbook.dto.PageRequestDTO;
import io.ahnjy.guestbook.dto.PageResultDTO;
import io.ahnjy.guestbook.entity.Guestbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * description    :
 * packageName    : io.ahnjy.guestbook.service
 * fileName       : GuestbookServiceTests
 * author         : ahnjy
 * date           : 2022/10/02
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/02        ahnjy       최초 생성
 */
@SpringBootTest
public class GuestbookServiceTests {

    @Autowired
    private GuestbookService service;

    @Test
    public void testRegister() {

        GuestbookDTO guestbookDTO = GuestbookDTO.builder()
                .title("Sample Title....")
                .content("Sample Content....")
                .writer("user0")
                .build();

        System.out.println(service.register(guestbookDTO));

    }

    // 엔티티 객체-> DTO 객체 변환 확인
    @Test
    public void testList() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();

        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(pageRequestDTO);

        System.out.println("PREV:  " + resultDTO.isPrev());
        System.out.println("NEXT:  " + resultDTO.isNext());
        System.out.println("TOTAL:  " + resultDTO.getTotalPage());
        System.out.println("----------------------------------------------------------------------------\r\n\r\n");

        for(GuestbookDTO guestbookDTO : resultDTO.getDtoList()) {
            System.out.println(guestbookDTO);
        }
        System.out.println("==========================================================================\r\n");

        resultDTO.getPageList().forEach(i -> System.out.println(i));

    }

    // 검색 테스트
    @Test
    public void testSearch(){

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .type("tc")
                .keyword("재영")
                .build();

        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(pageRequestDTO);

        System.out.println("PREV :  " + resultDTO.isPrev());
        System.out.println("NEXT :  " + resultDTO.isNext());
        System.out.println("TOTAL :  " + resultDTO.getTotalPage());

        System.out.println("-------------------------------------------------------------------------------");
        for(GuestbookDTO guestbookDTO : resultDTO.getDtoList()) {
            System.out.println(guestbookDTO);
        }

        System.out.println("=================================================================================");
        resultDTO.getPageList().forEach(i -> System.out.println(i) );

    }


}
