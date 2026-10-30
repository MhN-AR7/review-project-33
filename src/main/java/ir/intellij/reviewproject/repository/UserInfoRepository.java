package ir.intellij.reviewproject.repository;

import ir.intellij.reviewproject.dao.UserInfoDAO;
import ir.intellij.reviewproject.util.HibernateUtil;

import java.util.List;

public class UserInfoRepository implements Repository<UserInfoDAO>{

    public UserInfoDAO create(UserInfoDAO userInfoDAO) {
        return HibernateUtil.inTxReturn(
                em -> {
                    em.persist(userInfoDAO);
                    return userInfoDAO;
                }
        );
    }

    public List<UserInfoDAO> findAll() {
        return HibernateUtil.read(
                em -> em.createQuery("FROM UserInfoDAO", UserInfoDAO.class).getResultList()
        );
    }

}
