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
           member.setMemberType(MemberType.ADMIN);

           em.persist(member);

           em.flush();
           em.clear();

           String query = "select m.username, 'HELLO', true From Member m " +
                   "where m.type = :userType";
           List<Object[]> result = em.createQuery(query)
                   .setParameter("userType", MemberType.ADMIN)
                   .getResultList();
           for(Object[] objects : result){
               System.out.println("objects[0] = " + objects[0]);
               System.out.println("objects[0] = " + objects[1]);
               System.out.println("objects[0] = " + objects[2]);
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
