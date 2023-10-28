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
           member.setUsername("관리자");
           em.persist(member);
           Member member2 = new Member();
           member2.setUsername("관리자");
           em.persist(member2);

           em.flush();
           em.clear();

//           // case 문 예제
//           String query =   "select "+
//                                "case when m.age <= 10 then '학생요금' " +
//                                     "when m.age >= 60 then '경로요금' " +
//                                     "else '일반요금' " +
//                                "end " +
//                            "from Member m";

//           // COALESCE
//           String query = "select coalesce(m.username, '이름 없는 회원') from Member m";

//           // NULLIF
//           String query = "select nullif(m.username, '관리자') as username from Member m";

           String query = "select concat('a','b') From Member m"; // a || b와 동일, 이어붙이기
           String query1 = "select substring(m.username, 2,3) From Member m"; // 잘라내기
           String query2 = "select locate('de', 'abcdefg') From Member m";  // 위치 index 반환
           String query3 = "select function('group_concat', m.username) From Member m";

           List<String> result = em.createQuery(query3, String.class)
                   .getResultList();
           for (String s : result) {
               System.out.println("s = " + s);
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
