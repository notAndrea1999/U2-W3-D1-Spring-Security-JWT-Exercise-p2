package andreademasi.controllers;

import andreademasi.entities.User;
import andreademasi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping
    Page<User> getAllUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) {
        return userService.getAllUsers(page, size);
    }


    @GetMapping("/{id}")
    User findUserById(@PathVariable long id) {
        return userService.findUserById(id);
    }

    @PutMapping("/{id}")
    User findUserByIdAndUpdate(@PathVariable long id, @RequestBody User user) {
        return userService.findUserByIdAndUpdate(id, user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    void findUserByIdAndDelete(@PathVariable long id) {
        userService.findUserByIdAndDelete(id);
    }


}
