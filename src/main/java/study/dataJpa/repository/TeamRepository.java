package study.dataJpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import study.dataJpa.entity.Team;

import java.util.List;
import java.util.Optional;

@Repository
public class TeamRepository {
    @PersistenceContext
    private EntityManager em;

    public Team save(Team team) {
        em.persist(team);
        return team;
    }

    public void delete(Team team) {
        em.remove(team);
    }

    public List<Team> findAll() {
        return em.createQuery("select t from Team t", Team.class).getResultList();
    }

    public Team findById(int id) {
        return em.find(Team.class, id);
    }

    public Optional<Team> findById(String id) {
        Team team = em.find(Team.class, id);
        return Optional.ofNullable(team);
    }

    public  long count(){
        return em.createQuery("select count(t) from Team t", Long.class).getSingleResult();
    }
}
