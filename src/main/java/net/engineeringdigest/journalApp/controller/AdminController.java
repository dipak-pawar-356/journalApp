package net.engineeringdigest.journalApp.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import net.engineeringdigest.journalApp.cache.AppCache;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import net.engineeringdigest.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/journal/")
@Tag(name = "Admin APIs")
public class AdminController {

//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private AppCache appCache;
//
//    @Autowired
//    private JournalEntryService journalEntryService;


    private final UserService userService;
    private final AppCache appCache;
    private final JournalEntryService journalEntryService;

    public AdminController(UserService userService,
                           AppCache appCache,
                           JournalEntryService journalEntryService) {
        this.userService = userService;
        this.appCache = appCache;
        this.journalEntryService = journalEntryService;
    }

    @GetMapping("/all-users")
    public ResponseEntity<?> getAllUsers() {
        List<User> all = userService.getAll();
        if (all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create-admin-user")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userService.saveAdmin(user);
        return new ResponseEntity<>("Admin user created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/clear-app-cache")
    public void clearAppCache() {
        appCache.init();
    }

    @PostMapping("/create-for/{userName}")
    public ResponseEntity<JournalEntry> createForUser(
            @PathVariable String userName,
            @RequestBody JournalEntry entry
    ) {
        journalEntryService.saveEntry(entry, userName);
        return ResponseEntity.status(HttpStatus.CREATED).body(entry);
    }
}
