package net.engineeringdigest.journalApp.service;

import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class JournalEntryService {


    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private  UserService userService;


    @Transactional
    public JournalEntry saveEntry(JournalEntry journalEntry, String userName) {
        try {
            User user = userService.findByUserName(userName);
            if (user == null) {
                throw new IllegalArgumentException("User not found with username: " + userName);
            }
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepository.save(journalEntry);

            if (user.getJournalEntries() == null) {
                user.setJournalEntries(new ArrayList<>());
            }
            user.getJournalEntries().add(saved);
            userService.saveUser(user);
            return saved;
        } catch (Exception e) {
            System.err.println("Error while saving journal entry: " + e.getMessage());
            throw new RuntimeException("Failed to save journal entry: " + e.getMessage(), e);
        }
    }




    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }


//    public List<JournalEntry> getAll(){
//        return journalEntryRepository.findAll();
//    }

    public List<JournalEntry> getAll() {
        List<JournalEntry> entries = journalEntryRepository.findAll();
        System.out.println("✅ Entries fetched: " + entries.size());
        return entries;
    }


    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    @Transactional
    public boolean deleteById(ObjectId id, String userName){
        boolean removed = false;
        try{
            User user = userService.findByUserName(userName);
            if (user == null) {
                throw new IllegalArgumentException("User not found: " + userName);
            }
            removed = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
            if(removed){
                userService.saveUser(user);
                journalEntryRepository.deleteById(id);
            }

        }catch (Exception e){
            log.error("Error ", e);
            throw new RuntimeException("An error occurred while deleting the entry");
        }
        return removed;
    }

    public List<JournalEntry> findByUserName(String userName){
        try {
            User user = userService.findByUserName(userName);
            if (user == null) {
                throw new IllegalArgumentException("User not found: " + userName);
            }
            return user.getJournalEntries() != null ? user.getJournalEntries() : new ArrayList<>();
        } catch (Exception e) {
            log.error("Failed to retrieve journal entries for user: {}", userName, e);
            throw new RuntimeException("Could not fetch journal entries for user: " + userName, e);
        }
    }


}


//controller ---> service ---> repository