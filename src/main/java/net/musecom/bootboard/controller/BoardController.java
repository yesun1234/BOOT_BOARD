package net.musecom.bootboard.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import net.musecom.dto.BoardDto;
import net.musecom.service.BoardService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    
    private final BoardService bService;

    @GetMapping("/list")
    public String getList(Model model) {
        System.out.println("list");
        List<BoardDto> bDtoList = bService.findAll();
        model.addAttribute("lists", bDtoList);
        return "list";
    }
 
    @GetMapping("/write")
    public String getWrite() {
        System.out.println("write");
        return "write";
    }
 
    @PostMapping("/write")
    public String setWrite(@ModelAttribute BoardDto bDto) {
        System.out.println("boardDto = " + bDto);
        bService.write(bDto);
        return "redirect:list";
    }

}
