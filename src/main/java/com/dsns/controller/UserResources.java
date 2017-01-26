package com.dsns.controller;

import com.dsns.domain.Role;
import com.dsns.dto.RestMessageDTO;
import com.dsns.dto.UserDTO;
import com.dsns.security.Secured;
import com.dsns.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by mtustanovskyy on 11/2/16.
 */
@Slf4j
@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserResources {

    @Autowired
    UserService userService;

    @CrossOrigin
    @Secured(value = Role.ROLE_ADMIN)
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @Secured(value = Role.ROLE_ADMIN)
    @RequestMapping(method = RequestMethod.GET)
    List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value = "{id}/photo", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    byte[] getPhoto(@PathVariable Long id) throws IOException, SQLException {
        log.info("IN CONTROLLER getPhoto");
        return userService.getUserPhoto(id);
    }

    @RequestMapping(value = "{id}/photo", headers = "content-type=multipart/form-data", method = RequestMethod.PUT)
    RestMessageDTO changePhoto(@RequestParam("photo") MultipartFile photo, @PathVariable Long id) throws IOException {
        log.info("IN CONTROLLER changePhoto");
        return userService.changePhoto(photo, id);
    }

    @RequestMapping(value = "/me")
    UserDTO getMe() {
        return userService.getMe();
    }

    @Secured(value = Role.ROLE_ADMIN)
    @RequestMapping(value = "{id}/role", method = RequestMethod.PATCH)
    RestMessageDTO changeUserRole(@PathVariable Long id, String role) {
        return userService.changeUserRole(id, role);
    }

    @Secured(value = Role.ROLE_ADMIN)
    @RequestMapping(value = "{id}/regions", method = RequestMethod.PATCH)
    RestMessageDTO addRegions(@PathVariable Long id, @RequestBody List<Integer> regions) {
        log.info(regions.toString());
        return userService.setRegions(regions, id);
    }
}



