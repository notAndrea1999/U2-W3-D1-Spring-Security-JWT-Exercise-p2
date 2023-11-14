package andreademasi.services;

import andreademasi.entities.User;
import andreademasi.exceptions.UnauthorizedException;
import andreademasi.payloads.users.UserLoginDTO;
import andreademasi.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserService userService;

    @Autowired
    private JWTTools jwtTools;

    public String authUser(UserLoginDTO userLogin) {

        User newUser = userService.findByEmail(userLogin.email());
        if (newUser.getPassword().equals(userLogin.password())) {
            return jwtTools.createToken(newUser);
        } else {
            throw new UnauthorizedException("Credenziali non valide");
        }

    }
}
