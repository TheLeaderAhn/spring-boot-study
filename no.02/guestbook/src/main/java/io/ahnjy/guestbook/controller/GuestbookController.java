package io.ahnjy.guestbook.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * description    :
 * packageName    : io.ahnjy.guestbook.controller
 * fileName       : GuestbookController
 * author         : ahnjy
 * date           : 2022/09/24
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/09/24        ahnjy       최초 생성
 */
@Controller
@RequestMapping("/guestbook")
@Log4j2
public class GuestbookController {

    @GetMapping({"/","/list"})
    public String list(){

        log.info("list init ::::::::::::::::::::::::::");

        return "/guestbook/list";
    }

}
