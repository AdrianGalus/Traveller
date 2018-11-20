package traveller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import traveller.dtos.UserDTO;
import traveller.model.User;
import traveller.repositories.UserCredentialsRepository;

@Service
@Transactional
public class LoginService {

    @Autowired
    UserCredentialsRepository userCredentialsRepository;

    public Boolean checkCredentials(String login, String password) {

        Boolean check = userCredentialsRepository.loginCorrect(login, password);
        return check != null ? check : false;
    }
    public UserDTO login(String login) {

        User user = userCredentialsRepository.findByLogin(login);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setLogin(user.getLogin());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

}
