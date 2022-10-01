package io.ahnjy.guestbook.service;

import io.ahnjy.guestbook.dto.GuestbookDTO;
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
    Long register(Guestbook dto);

    default  Guestbook dtoToEntity(GuestbookDTO dto) {
        Guestbook entity = Guestbook.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();

        return entity;
    }
}
