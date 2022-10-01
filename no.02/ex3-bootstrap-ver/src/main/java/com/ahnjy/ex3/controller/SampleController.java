package com.ahnjy.ex3.controller;

import com.ahnjy.ex3.dto.SampleDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * description    :
 * packageName    : com.ahnjy.ex3.controller
 * fileName       : SampleController
 * author         : ahnjy
 * date           : 2022/09/21
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/09/21        ahnjy       최초 생성
 */
@Controller
@RequestMapping("/sample")
@Log4j2
public class SampleController {

    @GetMapping("/ex1")
    public void ex1(){

        log.info("ex1..........");

    }


    @GetMapping({"/ex2","/exlink"})
    public void exModel(Model model) {

        log.info("exModel...init ::::");

        List<SampleDTO> list = IntStream.rangeClosed(1,20).asLongStream().mapToObj(i -> {
            SampleDTO dto = SampleDTO.builder()
                    .sno(i)
                    .first("First..." + i)
                    .last("Last..." +i)
                    .regTime(LocalDateTime.now())
                    .build();
            return dto;
        }).collect((Collectors.toList()));

        model.addAttribute("list",list);
    }


    /**
     * inline 속성으로 리다이렉트 받는 곳
     */
    @GetMapping({"/ex3"})
    public void ex3(){

        log.info("ex3......");

    }

    /**
     * Comment
     * @param redirectAttributes
     * @return redirect:/sample/ex3
     */
    @GetMapping({"/exInline"})
    public String exInline(RedirectAttributes redirectAttributes) {

        log.info("exInline............");

        SampleDTO dto = SampleDTO.builder()
                .sno(100L)
                .first("First...100")
                .last("Last...100")
                .regTime(LocalDateTime.now())
                .build();

            redirectAttributes.addFlashAttribute("result","sucess");
            redirectAttributes.addFlashAttribute("dto",dto);

        return "redirect:/sample/ex3";
    }


    @GetMapping({"/exLayout1","/exLayout2", "/exTemplate", "/exSidebar"})
    public void exLayout1(){

        log.info("exLayout1.................");


    }



}