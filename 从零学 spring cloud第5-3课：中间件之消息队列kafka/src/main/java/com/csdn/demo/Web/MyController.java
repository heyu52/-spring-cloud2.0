package com.csdn.demo.Web;

import com.csdn.demo.Sender.MySender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private MySender sender;

    @RequestMapping("/mySend")
    public void mySend() throws Exception {
        sender.send();
    }
}
