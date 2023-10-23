package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity {

    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String username;

    @OneToOne
    @JoinColumn(name="LOCKER_ID")
    private Locker locker;

    @ManyToOne  // 일대다 양방향
    @JoinColumn(name="TEAM_ID", insertable = false, updatable = false)
    private Team team;

    @OneToMany(mappedBy = "member") // 다대다 연관관계
    private List<MemberProduct> memberProducts = new ArrayList<>();



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
