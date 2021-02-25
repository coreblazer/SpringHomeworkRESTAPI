package controllers;


import exceptions.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@RestController
@Component
@ComponentScan("exceptionhandlers")
public class RestAPIController {
    @GetMapping("/math/sum/{n1}/{n2}")
    public Integer getSum(@PathVariable int n1, @PathVariable int n2){
        return n1 + n2;
    }

    @PostMapping("/math/sum")
    public Integer getSumPost(@PathVariable int n1, @PathVariable int n2) {
        return n1 + n2;
    }

    ////Same as the post accepting json????
    @GetMapping("/weirdSum")
    @ResponseBody
    public Integer getSumJsonWeirdGet(@RequestParam(name="a") int value1 ,@RequestParam(name="b") int value2) {
        return value1+value2;
    }


    ////Same as the get accepting json????
    @PostMapping("/sum")
    @ResponseBody
    public Integer getSumJson(@RequestParam(name="a") int value1 ,@RequestParam(name="b") int value2) {
            return value1+value2;
    }

    @GetMapping("/sqr")
    @ResponseBody
    public String getSqr(@RequestParam(name="a") String value1) throws Exception {
        String value = null;
        try{
            Integer ff = Integer.parseInt(value1);
            value = ff.toString();
        }catch(Exception e){
            throw new CustomException(CustomException.ErrorCode.PARSE_ERROR);
        }
        return value;
    }
}
