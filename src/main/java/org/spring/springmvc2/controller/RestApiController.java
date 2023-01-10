package org.spring.springmvc2.controller;

import org.spring.springmvc2.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;

@RestController //페이지이동 X, ajax
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get1")
    public String get1() {

        return "get1";
    }
                //path1/userId=11
    @GetMapping("/path1/{userId}")
    public String path1(@PathVariable String userId){

        return userId;
    }
    @GetMapping("/path2/{userId}")
    public String path2(@PathVariable("userId") String uId){

        return uId;
    }
    @GetMapping("/param1") //form data
    public String param1(@RequestParam String userName,
                         @RequestParam String userAge){
        String data="이름: "+userName+", 나이: "+userAge;
        return data;
    }
    @GetMapping("/param2") //form data
    public String param2(@ModelAttribute MemberDto memberDto){ //@ModelAttribute는 생략 가능

        return memberDto.toString();
    }
    @PostMapping("/post1")
    public String post1(){

        return "post1";
    }
    @PostMapping("/post2")// JSON {"키":"값", "키":"값"}
    public @ResponseBody String post2(MemberDto memberDto){

        return memberDto.toString();
    }
    @PutMapping("/put1")
    public String put1(){
        return "put1";
    }
    @DeleteMapping(value = "/delete/{userId}")
    public String delete(@PathVariable String userId){
        return userId;
    }
}
