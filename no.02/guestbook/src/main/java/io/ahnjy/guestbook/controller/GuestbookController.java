package io.ahnjy.guestbook.controller;

import io.ahnjy.guestbook.dto.PageRequestDTO;
import io.ahnjy.guestbook.service.GuestbookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequiredArgsConstructor // @Autowired 대신 사용하자 자동주입
public class GuestbookController {

    private final GuestbookService service;


    @GetMapping("/")
    public String index(){
        return "redirect:/guestbook/list";
    }

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){

        log.info("list init ::::::::::::::::::::::::::" + pageRequestDTO);

        model.addAttribute("result", service.getList(pageRequestDTO));

    }

}
