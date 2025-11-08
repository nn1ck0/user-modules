import com.example.userservice.UserServiceApplication;
import com.example.userservice.dto.UserDto;
import com.example.userservice.entity.UserEntity;
import com.example.userservice.map.UserMapper;
import com.example.userservice.repo.UserRepo;
import com.example.userservice.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = UserServiceApplication.class)
@ActiveProfiles("test")
public class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void userServiceIntegrationTest() {
        UserEntity user = new UserEntity();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");

        UserDto savedUser = userService.createUser(userMapper.userEntityToUserDto(user));
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getUserId()).isNotNull();
        assertThat(savedUser.getFirstName()).isEqualTo("John");
        assertThat(userRepo.findById(savedUser.getUserId())).isPresent();
    }

    @Test
    public void userServiceIntegrationTest2() {
        UserEntity user = new UserEntity();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");

        UserDto userDto = userService.createUser(userMapper.userEntityToUserDto(user));
        UserDto userFromDB = userService.getUserById(userDto.getUserId());

        assertThat(userFromDB).isNotNull();
        assertThat(userFromDB.getFirstName()).isEqualTo("John");
        assertThat(userFromDB.getLastName()).isEqualTo("Doe");
        assertThat(userFromDB.getEmail()).isEqualTo("john.doe@example.com");

    }
}
