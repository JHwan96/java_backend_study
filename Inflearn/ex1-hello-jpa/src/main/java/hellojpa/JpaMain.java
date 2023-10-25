package hellojpa;

import javax.persistence.*;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        // code
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(new Address("homeCity1", "street","10000"));
            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressHistory().add(new Address("old1", "street","10000"));
            member.getAddressHistory().add(new Address("old2", "street","10000"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("=============== START ===============");
            Member findMember = em.find(Member.class, member.getId());
//            findMember.getAddressesHistory().setCity("") // 이렇게 하면 안됨
            Address oldAddress = findMember.getHomeAddress();
            findMember.setHomeAddress(new Address("newCity", oldAddress.getStreet(), oldAddress.getZipcode()));

            // 치킨 -> 한식
            findMember.getFavoriteFoods().remove("치킨");
            findMember.getFavoriteFoods().add("한식");

            findMember.getAddressHistory().remove(new Address("old1", oldAddress.getStreet(), oldAddress.getZipcode()));
            findMember.getAddressHistory().add(new Address("newCity", oldAddress.getStreet(), oldAddress.getZipcode()));

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
