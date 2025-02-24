/*
 * @Author: jackning 270580156@qq.com
 * @Date: 2024-01-26 17:05:17
 * @LastEditors: jackning 270580156@qq.com
 * @LastEditTime: 2024-01-26 17:30:36
 * @Description: bytedesk.com https://github.com/Bytedesk/bytedesk
 *   Please be aware of the BSL license restrictions before installing Bytedesk IM – 
 *  selling, reselling, or hosting Bytedesk IM as a service is a breach of the terms and automatically terminates your rights under the license. 
 *  仅支持企业内部员工自用，严禁用于销售、二次销售或者部署SaaS方式销售 
 *  Business Source License 1.1: https://github.com/Bytedesk/bytedesk/blob/main/LICENSE 
 *  contact: 270580156@qq.com 
 *  技术/商务联系：270580156@qq.com
 * Copyright (c) 2024 by bytedesk.com, All Rights Reserved. 
 */
package com.howtodoinjava.web;

import com.howtodoinjava.model.UserProfile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestResource {

  @GetMapping("/api/users/me")
  public ResponseEntity<UserProfile> profile() {
    Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    UserProfile profile = new UserProfile();
    profile.setName(jwt.getSubject());

    return ResponseEntity.ok(profile);
  }
}
