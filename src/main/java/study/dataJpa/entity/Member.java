package study.dataJpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity


@Getter
@Setter
@NamedQuery(
        name="Member.findByUsername",
        query = "select m from Member m where m.username = :username"
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "username", "age"})
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;


    public Member(String userName) {
        this.username = userName;
    }
    public Member(String username, int age) {
        this.username = username;
        this.age = age;

    }
    public Member(String username, int age, Team team) {
        this.username = username;
        this.age = age;
        if (team != null) {
            changeTeam(team);
        }
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }

}
