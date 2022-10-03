package io.ahnjy.guestbook.service;

import io.ahnjy.guestbook.dto.GuestbookDTO;
import io.ahnjy.guestbook.dto.PageRequestDTO;
import io.ahnjy.guestbook.dto.PageResultDTO;
import io.ahnjy.guestbook.entity.Guestbook;

/**
 * description    :
 * packageName    : io.ahnjy.guestbook.service
 * fileName       : GuestbookService
 * author         : ahnjy
 * date           : 2022/10/01
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/01        ahnjy       최초 생성
 */
public interface GuestbookService {
    Long register(GuestbookDTO dto);

    PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO);

    // 방명록 조회
    GuestbookDTO read(Long gno);

    default  Guestbook dtoToEntity(GuestbookDTO dto) {
        Guestbook entity = Guestbook.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();

        return entity;
    }

    default GuestbookDTO entityToDto(Guestbook entity) {

        GuestbookDTO dto = GuestbookDTO.builder()
                .gno(entity.getGno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();

        return dto;
    }


}
