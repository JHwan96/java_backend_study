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
            Member member = new Member();
            member.setUsername("member1");
            em.persist(member);

           TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class);
//           Query query3 = em.createQuery("select m.username, m.age from Member m");
           List<Member> resultList = query1.getResultList();
           // 파라미터 바인딩
           Member singleResult = em.createQuery("select m from Member m where m.username = :username", Member.class)
                   .setParameter("username", "member1")
                   .getSingleResult();//getSingleResult
           System.out.println("singleResult.getUsername() = " + singleResult.getUsername());

       } catch(Exception e){
           tx.rollback();
           e.printStackTrace();
       } finally{
           em.close();
       }
       emf.close();
   }
}
