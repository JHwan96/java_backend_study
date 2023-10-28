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
           Team teamA = new Team();
           teamA.setName("팀A");
           em.persist(teamA);

           Team teamB = new Team();
           teamB.setName("팀B");
           em.persist(teamB);

           Member member1 = new Member();
           member1.setUsername("회원1");
           member1.setTeam(teamA);
           em.persist(member1);

           Member member2 = new Member();
           member2.setUsername("회원2");
           member2.setTeam(teamA);
           em.persist(member2);

           Member member3 = new Member();
           member3.setUsername("회원3");
           member3.setTeam(teamB);
           em.persist(member3);

           em.flush();
           em.clear();

           String query = "select distinct t from Team t join fetch t.member";

           List<Team> result = em.createQuery(query, Team.class)
                           .getResultList();
           for (Team team : result){
               System.out.println("member : " + team.getName() );
               for ( Member member : team.getMember()){
                   System.out.println("member = " + member);
               }

               // join fetch 사용하지 않았을 때:
               // 회원 100명 -> N+1번의 SQL (101번)
           }

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
