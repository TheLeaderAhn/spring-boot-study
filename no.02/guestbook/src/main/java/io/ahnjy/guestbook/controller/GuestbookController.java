package io.ahnjy.guestbook.controller;

import io.ahnjy.guestbook.dto.GuestbookDTO;
import io.ahnjy.guestbook.dto.PageRequestDTO;
import io.ahnjy.guestbook.dto.PageResultDTO;
import io.ahnjy.guestbook.entity.Guestbook;
import io.ahnjy.guestbook.service.GuestbookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import java.util.List;

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
    public String index() {

        return "redirect:/guestbook/list";
    }

    // 목록 조회

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {

        log.info("list init ::::::::::::::::::::::::::" + pageRequestDTO);

        PageResultDTO<GuestbookDTO, Guestbook> result = service.getList(pageRequestDTO);
        log.info("result:::" + result);

        model.addAttribute("result", result);

    }


    // 등록페이지 // 등록처리
    @GetMapping("/register")
    public void regisgter() {

        log.info("register get...");

    }

    @PostMapping("/register")
    @Transactional
    public String registerPost(GuestbookDTO dto, RedirectAttributes redirectAttributes) {

        log.info("dto........" + dto);

        // 새로 추가된 엔티티
        Long gno = service.register(dto);

        // 모달 처리용
        redirectAttributes.addFlashAttribute("msg", gno);

        return "redirect:/guestbook/list";
    }


    // 방명록 상세 , 수정 후 상세 조회 통합
    @GetMapping({"/read", "/modify"})
    public void read(long gno, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model ){

        log.info("requestDTO....." + requestDTO);
        log.info("gno..... " + gno);

        GuestbookDTO dto = service.read(gno);

        model.addAttribute("dto", dto);

    }


    // 수정
    @PostMapping("/modify")
    public String modify(GuestbookDTO dto,
                         @ModelAttribute("requestDTO") PageRequestDTO requestDTO,
                         RedirectAttributes redirectAttributes){


        log.info("post modify.........................................");
        log.info("dto: " + dto);

        service.modify(dto);

        redirectAttributes.addAttribute("page",requestDTO.getPage());
        redirectAttributes.addAttribute("type",requestDTO.getType());
        redirectAttributes.addAttribute("keyword",requestDTO.getKeyword());
        redirectAttributes.addAttribute("gno",dto.getGno());

        return "redirect:/guestbook/read";

    }


    // 게시물 삭제
    @PostMapping("/remove")
    public String remove(long gno, RedirectAttributes redirectAttributes) {

        log.info("삭제 할 gno : " + gno);

        service.remove(gno);

        redirectAttributes.addFlashAttribute("msg",gno);

        return "redirect:/guestbook/list";
    }





}

