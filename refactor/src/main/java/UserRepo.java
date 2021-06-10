public class UserRepo {
    public boolean checkIfUserExisted(String email, String password) {
        return false;
        //...query db to check if email&password exists...
    }

    public User getUserByEmail(String email) {
        return new User();
    }
}