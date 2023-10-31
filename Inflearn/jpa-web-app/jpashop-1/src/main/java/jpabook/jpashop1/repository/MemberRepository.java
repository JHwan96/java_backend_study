package jpabook.jpashop1.repository;

import jpabook.jpashop1.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
//    @PersistenceContext
    private final EntityManager em;

    public Long save(Member member){
        em.persist(member);
        return member.getId();
    }
    public Member findOne(Long id){
        return em.find(Member.class, id);
    }
    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
    public List<Member> findAll(){
        return em.createQuery("select m from member m", Member.class)
                .getResultList();
    }

}
