package com.ahnjy.ex01.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description    :
 * packageName    : com.ahnjy.ex01.Controller
 * fileName       : SampleController
 * author         : ahnjy
 * date           : 2022/09/19
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/09/19        ahnjy       최초 생성
 */
@RestController
public class SampleController {

    @GetMapping("/hello")
    public String[] hello(){
        return new String[]{"hello", "world"};
    }


}
