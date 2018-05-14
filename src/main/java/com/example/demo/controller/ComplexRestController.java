package com.example.demo.controller;
import com.example.demo.complex.Complex;
import com.example.demo.model.ComplexRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/complex")
public class ComplexRestController {
    @PostMapping("/add")
    public Complex add(@RequestBody ComplexRequest complexRequest) {
        return  complexRequest.getLeft()
                                .add(complexRequest.getRight());
    }


}
