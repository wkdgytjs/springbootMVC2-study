package org.spring.springmvc2.controller;

import org.spring.springmvc2.dto.MemberDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping("/basic")
public class BasicController {

    @GetMapping("/basicIndex")
    public String index() {
        // templates/basic/basicIndex.html
        return "basic/basicIndex";
    }

    @GetMapping("/project1")
    public String project1(Model model) {
        //Model "name" -> 데이터 가지고 -> View -> basic/project1
        // key, value
        model.addAttribute("name", "basicProject");
        return "basic/project1";
    }

    //@ModelAttribute -> 요청 데이터를 처리 form데이터
    //@ModelAttribute MemberDto dto -> Dto를 미리 생성 <- form으로 전송 1대1 맵핑
    @PostMapping("/project2")
    public String project2(@ModelAttribute MemberDto dto, Model model) {
        // 데이터 저장 Memberdto에 자동 저장 -> View로 전달
        model.addAttribute("member", dto);
        return "basic/project2";
    }
    @GetMapping("/project3")
    public ModelAndView project3(){
        ModelAndView mv= new ModelAndView();

        Map<String, Object> info= new HashMap<>(); //키:값
        info.put("userName", "son");
        info.put("userAge", 30);
        info.put("date", LocalDateTime.now());

       /* Set<String> keys=info.keySet();
        Iterator<String> iterator=keys.iterator();
        while(iterator.hasNext()){
            String key=iterator.next();

        }*/

        List<String> project= new ArrayList<>(); // 리스트 forEach
        project.add("spring");
        project.add("jsp");
        project.add("thymeleaf");
        project.add("jpa");

        mv.addObject("info", info); //View 전달 객체
        mv.addObject("project", project); //View 전달 객체
        mv.setViewName("basic/project3"); // -> View

        return mv;
    }

    @GetMapping("/joinOk")
    public String joinOk(Model model, MemberDto memberDto) {
        //페이지 이동 -> join페이지에 memberDto 빈객체 전달
        model.addAttribute("memberDto",memberDto);
        return "basic/join";
    }
    @PostMapping("/joinOk")
    public String joinOk2(@ModelAttribute("memberDto") MemberDto memberDto, Model model) {

        model.addAttribute("member", memberDto);

        return "index";
    }
}
