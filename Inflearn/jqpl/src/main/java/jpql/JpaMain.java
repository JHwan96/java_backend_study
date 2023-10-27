package jpql;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
   public static void main(String[] args){
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
       EntityManager em = emf.createEntityManager();
       EntityTransaction tx = em.getTransaction();
       tx.begin();
       try {
           Team team = new Team();
           team.setName("teamA");
           em.persist(team);

           Member member = new Member();
           member.setUsername("member1");
           member.setAge(19);
           member.setTeam(team);

           em.persist(member);

           em.flush();
           em.clear();

//            // 페이징 연습
//           List<Member> result = em.createQuery("select m from Member m order by m.age desc", Member.class)
//                   .setFirstResult(0)
//                   .setMaxResults(10)
//                   .getResultList();

//           // Join
//           String query = "select m from Member m left join m.team t where t.name = :teamName";
//           String thetaQuery = "select m from Member m, Team t where m.username = :teamName";
           String query = "select m from Member m left join m.team t on t.name = :teamName";
           List<Member> result = em.createQuery(query, Member.class)
                   .setParameter("teamName", "teamA")
                   .getResultList();

           tx.commit();
       } catch(Exception e){
           tx.rollback();
           e.printStackTrace();
       } finally{
           em.close();
       }
       emf.close();
   }
}
