package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
// @SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq")   // sequence
@TableGenerator(
        name = "member_seq_generator",
        table = "my_sequence",
        pkColumnValue = "member_seq",
        allocationSize =1)
public class Member {

    @Id     //PK
    @GeneratedValue(strategy = GenerationType.TABLE, generator="member_seq_generator")
    private Long id;
    @Column(name = "name", nullable = false)
    private String username;

    protected Member() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
