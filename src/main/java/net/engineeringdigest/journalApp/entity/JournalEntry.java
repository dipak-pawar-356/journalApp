//package net.engineeringdigest.journalApp.entity;
//
//public class JournalEntry {
//
//    public long getId() {
//        return id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    private  long id;
//
//    private  String title;
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    private String content;
//}






package net.engineeringdigest.journalApp.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "journal_entries")
@Data
@NoArgsConstructor
public class JournalEntry {

    @Id
    private ObjectId id;

    @NonNull
    private String title;

    private String content;

    private LocalDateTime date;

//    // Default constructor
//    public JournalEntry() {}
//
//    // All-args constructor
//    public JournalEntry(ObjectId id, String title, String content) {
//        this.id = id;
//        this.title = title;
//        this.content = content;
//    }


}
