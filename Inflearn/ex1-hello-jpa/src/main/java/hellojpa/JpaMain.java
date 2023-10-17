package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        // code
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            // 준영속 (detach)
            Member member = em.find(Member.class, 150L);
            member.setName("AAAAA");

//            em.detach(member);  // JPA 에서 관리 안함
//            em.close();   // 영속성 컨텍스트 종료
            em.clear(); // 영속성 컨텍스트를 통으로 지움

            Member member2 = em.find(Member.class, 150L);

            System.out.println("=======================");

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally{
            em.close();
        }
        emf.close();
    }
}
