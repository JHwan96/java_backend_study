package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        // code
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("helloB");
//            em.persist(member);       // 멤버 추가

//            em.remove(findMember); // 멤버 삭제
            Member findMember = em.find(Member.class, 1L); // 멤버 검색
            findMember.setName("helloJPA"); // 멤버 수정 (update해줌)
            
            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally{
            em.close();
        }
        emf.close();
    }
}
