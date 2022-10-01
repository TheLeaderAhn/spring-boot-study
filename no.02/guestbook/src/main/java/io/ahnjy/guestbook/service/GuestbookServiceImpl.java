package io.ahnjy.guestbook.service;

import io.ahnjy.guestbook.entity.Guestbook;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * description    :
 * packageName    : io.ahnjy.guestbook.service
 * fileName       : GuestbookServiceImpl
 * author         : ahnjy
 * date           : 2022/10/01
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/01        ahnjy       최초 생성
 */
@Service
@Log4j2
public class GuestbookServiceImpl implements GuestbookService{

    @Override
    public Long register(Guestbook dto) {
        return null;
    }
}
