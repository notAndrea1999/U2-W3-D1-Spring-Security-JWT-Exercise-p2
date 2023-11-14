package andreademasi.controllers;

import andreademasi.entities.User;
import andreademasi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    Page<User> getAllUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) {
        return userService.getAllUsers(page, size);
    }


    @GetMapping("/{id}")
    User findUserById(@PathVariable long id) {
        return userService.findUserById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    User findUserByIdAndUpdate(@PathVariable long id, @RequestBody User user) {
        return userService.findUserByIdAndUpdate(id, user);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void findUserByIdAndDelete(@PathVariable long id) {
        userService.findUserByIdAndDelete(id);
    }


    @GetMapping("/me")
    public UserDetails getLoggedProfile(@AuthenticationPrincipal UserDetails loggedUser) {
        return loggedUser;
    }

    @PutMapping("/me")
    public UserDetails updateLoggedProfile(@AuthenticationPrincipal User loggedUser, @RequestBody User user) {
        return userService.findUserByIdAndUpdate(loggedUser.getUserId(), user);
    }

    @DeleteMapping("/me")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
    public void getProfile(@AuthenticationPrincipal User loggedUser) {
        userService.findUserByIdAndDelete(loggedUser.getUserId());
    }

    ;

}
