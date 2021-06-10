
public class UserService {
    private UserRepo userRepo;//通过依赖注入或者IOC框架注入

    public User login(String email, String password) throws Exception {
//        if (!EmailValidation.validate(email)) {
//            // ... throw InvalidEmailException...
//        }
//
//        if (!PasswordValidation.validate(password)) {
//            // ... throw InvalidPasswordException...
//        }

        User user = userRepo.getUserByEmail(email);
        if (user == null || user.getPassword().equals(password)) {
            throw new Exception("");
        }
        return user;
    }
}
