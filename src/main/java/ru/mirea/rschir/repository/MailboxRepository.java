package ru.mirea.rschir.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.mirea.rschir.model.Mailbox;

import java.util.List;

public interface MailboxRepository extends MongoRepository<Mailbox, String> {

    public List<Mailbox> findAllBySender(String sender);
    public List<Mailbox> findAllByReceiver(String receiver);
}
