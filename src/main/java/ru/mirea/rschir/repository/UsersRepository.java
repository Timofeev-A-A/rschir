package ru.mirea.rschir.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.mirea.rschir.model.Users;

public interface UsersRepository extends MongoRepository<Users, String> {

    public Users findByEmail(String email);
    public boolean existsUsersByEmail(String email);
}
