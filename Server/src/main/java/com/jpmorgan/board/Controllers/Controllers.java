package com.jpmorgan.board.Controllers;

import com.jpmorgan.board.Services.LandingPage;
import com.jpmorgan.board.Services.Message;
import javafx.scene.layout.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RestController

public class Controllers {

    @Autowired
    private ArrayList arrayList ;


    @CrossOrigin("http://localhost:3000")
    @GetMapping(path = "/", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public LandingPage welcome(LandingPage message){
        LandingPage title = new LandingPage("Message Board");
        return title;
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping(path = "/dummy", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList dummy(){
        String dummyMessage = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

        StringBuffer stringBuffer = new StringBuffer();

        if(dummyMessage.length() <= 500){
            stringBuffer.append(dummyMessage);
        }
        else{
            stringBuffer.append(dummyMessage.substring(0, 500));

        }
        String newMessage = stringBuffer.toString();



        Message message = new Message("john.doe@gmail.com", newMessage, "16/12/2020");
        Message message2 = new Message("joe.bloggs@gmail.com", newMessage, "16/12/2020");
        Message message3 = new Message("jimmy@gmail.com", newMessage, "16/12/2020");


        arrayList.add(message);
        arrayList.add(message2);
        arrayList.add(message3);
        return arrayList;
    }
    @CrossOrigin("http://localhost:3000")
    @PostMapping(path="/add", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Message createMessage(@RequestBody  Message msg){

        String email = msg.getEmail();
        String message = msg.getMessage();
        String key = msg.getKey();

        StringBuilder stringBuilder = new StringBuilder();

        if(message.length() <= 500){
            stringBuilder.append(message);
        }else{
            stringBuilder.append(message.substring(0, 500));
        }
        String newMsg = stringBuilder.toString();

        Message newMessage = new Message(email, newMsg, key);

        arrayList.add(newMessage);
        return msg;

    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping(path = "/api/v1", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List collections(){


            List newList = new LinkedList<Message>();

            Iterator iterator = arrayList.iterator();
            while(iterator.hasNext()){
                Message m = (Message) iterator.next();
                newList.add(m);

            }

            Collections.reverse(newList);

        return newList;





    }


}
