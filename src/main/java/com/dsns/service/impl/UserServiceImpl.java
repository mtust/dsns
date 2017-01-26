package com.dsns.service.impl;

import com.auth0.jwt.internal.org.apache.commons.io.IOUtils;
import com.dsns.domain.Region;
import com.dsns.domain.Role;
import com.dsns.domain.User;
import com.dsns.domain.UserPhoto;
import com.dsns.dto.RestMessageDTO;
import com.dsns.dto.UserDTO;
import com.dsns.dto.UserRegistrationDTO;
import com.dsns.exception.GeneralServiceException;
import com.dsns.exception.ObjectAlreadyExistException;
import com.dsns.repository.RegionRepository;
import com.dsns.repository.UserPhotosRepository;
import com.dsns.repository.UserRepository;
import com.dsns.service.UserService;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by mtustanovskyy on 10/29/16.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPhotosRepository userPhotosRepository;

    @Autowired
    private HttpServletRequest requestContext;

    @Autowired
    private RegionRepository regionRepository;

    @Override
    public void save(User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Transactional
    @Override
    public UserDTO getUserByUsername(String username) {
        UserDTO userDTO = new UserDTO();
        User user = userRepository.findByEmail(username);
        userDTO.setRoleName(user.getRole().name());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        return userDTO;
    }

    @Transactional
    @Override
    public User getUserByUsernameAndPassword(String username, String password) {

        User user = userRepository.findByEmail(username);

        if (user != null && !BCrypt.checkpw(password, user.getPassword())) {
            log.warn("iмя користувача або пароль неправильні: ");
            throw new GeneralServiceException("iмя користувача або пароль неправильні");
        }

        return user;
    }

    @Transactional
    @Override
    public User createUser(UserRegistrationDTO userRegistrationDTO) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User user = new User();
        if (!userRegistrationDTO.getPassword().equals(userRegistrationDTO.getConfirmPassword())) {
            throw new GeneralServiceException("Паролі не співпадають");
        }
        if (userRepository.findByEmail(userRegistrationDTO.getEmail()) != null) {
            throw new ObjectAlreadyExistException("Такий користувач вже існує");
        }
        user.setFirstName(userRegistrationDTO.getFirstName());
        user.setLastName(userRegistrationDTO.getLastName());
        user.setEmail(userRegistrationDTO.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(userRegistrationDTO.getPassword()));
        user.setRole(Role.ROLE_OPERATOR);
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setRoleName(user.getRole().name());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        return userDTO;
    }

    @Override
    @Transactional
    public byte[] getUserPhoto(Long id) throws SQLException, IOException {
        User user = userRepository.findById(id);
        if (user.getPhoto() == null) {
            return IOUtils.toByteArray(new URL("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQoiJVlwkYJvPNp7vjnrPPGEe3MDBvcDbaFjkBBjo5_OLlMGLrG_sMtMcCR").openStream());
        }
        return user.getPhoto().getPhoto();
    }


    @Override
    @Transactional
    public RestMessageDTO changePhoto(MultipartFile photo, Long id) throws IOException {
        User user = userRepository.findById(id);
        log.info("IN SERVICE  changePhoto");
        UserPhoto userPhoto = new UserPhoto();
        userPhoto.setPhoto(photo.getBytes());
        user.setPhoto(userPhoto);
        userPhotosRepository.save(userPhoto);
        userRepository.save(user);
        return new RestMessageDTO("Success", true);
    }

    @Override
    public Set<Region> getUserRegions(Long userId) {
        log.info("userId: " + userId);
        return userRepository.findById(userId).getRegions();
    }

    @Override
    public UserDTO getMe() {
        Long userId = Long.parseLong(((Claims) requestContext.getAttribute("claims")).get("id").toString());
        return this.getUserById(userId);
    }

    @Override
    public RestMessageDTO changeUserRole(Long id, String role) {
        User user = userRepository.findById(id);
        user.setRole(Role.valueOf(role));
        userRepository.save(user);
        return new RestMessageDTO("Success", true);
    }

    @Override
    @Transactional
    public List<UserDTO> getUsers() {
        List<UserDTO> userDTOS = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for (User user: users) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setRoleName(user.getRole().name());
            userDTO.setEmail(user.getEmail());
            userDTO.setFirstName(user.getFirstName());
            userDTO.setLastName(user.getLastName());
            userDTOS.add(userDTO);
        }
        return  userDTOS;
    }

    @Transactional
    @Override
    public RestMessageDTO setRegions(List<Integer> regionsId, Long id) {
        User user = userRepository.findById(id);
        List<Region> regions = regionRepository.findAll();
        Set<Region> userRegions = user.getRegions();
        for (Integer integer : regionsId) {
            userRegions.add(regions.get(integer - 1));
        }
        userRepository.save(user);
        return new RestMessageDTO("Succes", true);
    }
}
