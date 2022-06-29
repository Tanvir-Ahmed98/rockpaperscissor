package com.rockpaperscissor.finalproject.controller;




import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/game")
public class GameController {
	@GetMapping()
    public String index(
        @RequestParam(value = "select", required = false) Integer  urlvalue,Model model) {
        model.addAttribute("select", urlvalue);
        String finalresult;
        switch (urlvalue) {
            case 1:
                finalresult = "rock"; 
                break;
            case 2:
                 finalresult = "paper";
                break;
            case 3:
                finalresult = "scissor";
                break;
            default:
                finalresult = "unknown";
                break;
        }
        int min=1,max=3;
        int randomNumber = ThreadLocalRandom.current().nextInt(min, max + 1);
       
        String roundResult="";
        String computerchoice;
        switch (randomNumber) {
            case 1:
                 computerchoice = "rock"; 
                break;
            case 2:
                 computerchoice = "paper";
                break;
            case 3:
                  computerchoice = "scissor";
                break;
            default:
                 computerchoice = "unknown";
                break;
        }
    
        if (urlvalue==randomNumber)
             roundResult="Drawn";
        if (urlvalue==1 && randomNumber==3)
              roundResult="You Win";
        else if(urlvalue==3 && randomNumber==1)
        roundResult="You Lose";     
        if (urlvalue==3 && randomNumber==2)
            roundResult="You Win";
        else if(urlvalue==2 && randomNumber==3)
            roundResult="You Lose";
        if (urlvalue==2 && randomNumber==1)
            roundResult="You Win";
        else if(urlvalue==1 && randomNumber==2)
           roundResult="You Lose";
        if (urlvalue==3 && randomNumber==1)
             roundResult="You Lose";
        else if(urlvalue==1 && randomNumber==3)
                 roundResult="You Win";
    
  
        model.addAttribute("results", finalresult);
        model.addAttribute("number", computerchoice);
        model.addAttribute("roundResult", roundResult);
      
        
        
        return "result";
    }

    @GetMapping("/")
    public String back(){
    return "index";

    }

}