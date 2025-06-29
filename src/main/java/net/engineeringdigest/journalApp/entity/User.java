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
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document(collection = "users")
@Data
@NoArgsConstructor // ✅ Add this for default constructor
@AllArgsConstructor // (Optional) for convenience
@Builder
public class User {

    @Id
    private ObjectId id;

    @Indexed(unique = true)
    @NonNull
    private String userName;

    @NonNull
    private String password;

    @DBRef
    private List<JournalEntry> journalEntries = new ArrayList<>();
    private List<String> roles;



}
