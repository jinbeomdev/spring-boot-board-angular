package com.fasoo.boardangular.controller;

import com.fasoo.boardangular.dto.LoginFormDto;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;

@RestController
public class LoginController {

  @PostMapping("/login")
  public boolean login(@RequestBody LoginFormDto loginFormDto) {
    /**
     * TODO: need to connect to database
     */
    return loginFormDto.getId().equals("admin") && loginFormDto.getPw().equals("1111");
  }

  @GetMapping("/user")
  public Principal user(HttpServletRequest request) {
    /**
     *     https://developer.mozilla.org/ko/docs/Web/HTTP/Headers/Authorization
     *     HTTP Authorization 대한 글
     *
     *     Authorization: Basic YWxhZGRpbjpvcGVuc2VzYW1l
     *     위의 같이 들어오기 때문에 Basic 뒤의 token부분을 가져와 Base64로 decoding을 한 후,
     *     aladdin:opensesame와 같이 (사용자:비밀번호)형식이기 때문에 앞의 사용자 ID를 추출하기 하기 위해
     *     colon(:)을 기준으로 스플릿한 결과의 첫 번째 부분(아이디)를 리턴한다.
     */
    String authToken = request.getHeader("Authorization")
      .substring("Basic".length()).trim();
    return () -> new String(Base64.getDecoder()
      .decode(authToken)).split(":")[0];
  }

  /**
   * TODO: need to delete this method. this method is for test
   */
  @GetMapping("/principle/user")
  public Principal principalUser(Principal user) {
    return user;
  }
}

