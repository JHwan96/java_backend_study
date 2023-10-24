package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.*;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        // code
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Member member1 = new Member();
            member1.setUsername("hello");
            em.persist(member1);

            em.flush();
            em.clear();

            Member refMember = em.getReference(Member.class, member1.getId());
            System.out.println("reference.getClass() = " + refMember.getClass());   // proxy

//            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));   // 초기화 여부 확인

            Hibernate.initialize(refMember);    // 프록시 강제 초기화

          /*em.detach(refMember);
            em.clear(); // 준영속 상태일 때 에러 확인
            refMember.getUsername();*/

            /*Member findMember = em.find(Member.class, member1.getId());
            System.out.println("findmember.getClass() = " + findMember.getClass());
            System.out.println("a == a: " + (refMember == findMember));*/   // == 연산자 확인
            tx.commit();
        } catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        } finally{
            em.close();
        }
        emf.close();
    }

    private static void logic(Member m1, Member m2) {
        System.out.println("m1 == m2: " + (m1 instanceof Member));
        System.out.println("m1 == m2: " + (m2 instanceof Member));
    }
}
