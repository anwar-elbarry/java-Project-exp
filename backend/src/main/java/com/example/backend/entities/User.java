import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity

public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;
    @Column(name = "username", unique = true, nullable = false)
    private String username;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    @JsonIgnore
    private String password;


// getters and setters
   public function getId(): Long {
        return id
    }

    public fun setId(id: Long) {
        this.id = id
    }

    public function getUsername(): String {
        return username
    }

    public function setUsername(username: String) {
        this.username = username
    }

    public function getEmail(): String {
        return email
    }

    public function setEmail(email: String) {
        this.email = email
    }

    public function getPassword(): String {
        return password
    }

    public function setPassword(password: String) {
        this.password = password
    }
}