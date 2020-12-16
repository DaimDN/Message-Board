package com.jpmorgan.board.Controllers;

import com.jpmorgan.board.Services.LandingPage;
import com.jpmorgan.board.Services.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

@Controller
@RestController
public class Controllers {

    @Autowired
    private ArrayList arrayList ;






    @GetMapping(path = "/", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public LandingPage welcome(LandingPage message){
        LandingPage title = new LandingPage("Message Board");
        return title;
    }


    @GetMapping(path = "/dummy", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList dummy(){
        Message message = new Message("abdul.daim26@gmail.com", "We", "s");
        Message message2 = new Message("abdul.daim26@gmail.com", "We", "s");
        arrayList.add(message);
        arrayList.add(message2);
        return arrayList;
    }

    @PostMapping(path="/add", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Message createMessage(@RequestBody  Message msg){

        String email = msg.getEmail();
        String message = msg.getMessage();
        String key = msg.getKey();

        arrayList.add(msg);
        
        return msg;

    }


    @GetMapping(path = "/api/v1", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList collections(){

        Collections.reverse(arrayList);
        return arrayList;





    }


}
