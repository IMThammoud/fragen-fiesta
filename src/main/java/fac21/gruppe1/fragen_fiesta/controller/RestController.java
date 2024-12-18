package fac21.gruppe1.fragen_fiesta.controller;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    public RestController() {
        Gson gson = new Gson();
    }

    @PostMapping("/api/submit/question")
    public String submitQuestion(@RequestBody HashMap <String, String> question) {


        return null;
    }

    @PostMapping("/api/submit/blabla")
    public String submitbla(@RequestBody HashMap <String, String> question) {


        return null;
    }
}
