package c.c.k.ctn;

import c.c.k.domain.User;
import c.c.k.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RestCtn {
    @Resource
    private UserService userService;

   /* @GetMapping("002")
    public Object get001(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a", "b");
        return jsonObject;
    }*/
}
