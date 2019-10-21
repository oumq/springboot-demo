import cn.boombiubiu.Application;
import cn.boombiubiu.utils.JwtUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TokenTest {

    @Autowired
    private JwtUtils jwtUtils;

    @Test
    public void createToken () {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user", "oumq");
        String token = jwtUtils.createJwt(map);
        System.out.println(token);
    }
}
