package my.utm.ip.lowcarbon.models.user.userRepo;

import java.util.List;

import my.utm.ip.lowcarbon.models.user.User;

public interface UserRepository {
    List<User> getAllUser();
    User getUserByEmail(String email);
    void createUser(User user);
    void updateUser(User user);
    void deleteParticipant(String participantId);
    String generateCustomId();
}
