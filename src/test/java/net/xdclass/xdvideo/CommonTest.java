package net.xdclass.xdvideo;

import io.jsonwebtoken.Claims;
import net.xdclass.xdvideo.domain.User;
import net.xdclass.xdvideo.utils.JwtUtils;
import org.junit.Test;

public class CommonTest {

    @Test
    public void testGeneJwt() {
        User user = new User();
        user.setId(777);
        user.setHeadImg("github");
        user.setName("gh");

        String token = JwtUtils.geneJsonWebToken(user);
        System.out.println(token);
    }

    @Test
    public void testCheck() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ4ZGNsYXNzIiwiaWQiOjc3NywibmFtZSI6ImdoIiwiaW1nIjoiZ2l0aHViIiwiaWF0IjoxNTg1NDg5ODEyLCJleHAiOjE1ODYwOTQ2MTJ9.1WD-n9TQ4pSqK4va6DTvI116LufKvmmayppnzcXpTD4";
        Claims claims = JwtUtils.checkJWT(token);
        if (claims != null) {
            String name = (String)claims.get("name");
            String img = (String)claims.get("img");
            int id =(Integer) claims.get("id");
            System.out.println(name);
            System.out.println(img);
            System.out.println(id);
        } else {
            System.out.println("非法token");
        }
    }
}
