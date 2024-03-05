package edu.ib.technologiesieciowe;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello world!";
    }
    @GetMapping("/helloSomeone")
    public String helloSomeone(@RequestParam(required = false) String name,
                               @RequestParam String surname) {
        if(name == null) name = "John";
        return "Hello " + name + " " + surname + "!";
    }
    @GetMapping("/helloPath/{name}")
    public String helloFromPath(@PathVariable String name) {
        return "Hello " + name + "!";
    }
    @GetMapping("/addNumbers")
    public double addNumbers(@RequestParam double num1, @RequestParam double num2) {
        return num1 + num2;
    }
}
