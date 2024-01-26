/*
 * @Author: jack ning github@bytedesk.com
 * @Date: 2024-01-26 17:05:17
 * @LastEditors: jack ning github@bytedesk.com
 * @LastEditTime: 2024-01-26 17:08:10
 * @FilePath: /Spring-Security/spring-boot-role-based-authorization/src/main/java/com/example/springbootrolebasedauthorization/web/TestController.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package com.example.springbootrolebasedauthorization.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableMethodSecurity
@RestController
public class TestController {

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/test")
    public Authentication getAuthenticatedUser() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @GetMapping("/noRoleNeeded")
    public String publicResource() {
        return "This resource only requires authentication";
    }

    @GetMapping("/roleNeeded")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String privateResource() {
        return "This resource requires the ADMIN role";
    }
}
