package dev.shintani.demo;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExampleController {

    @RequestMapping("/")
    String home() {
      return "Hello, World!";
    }
}
