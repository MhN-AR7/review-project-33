package ir.intellij.reviewproject.repository;

import ir.intellij.reviewproject.dao.DAO;

public interface Repository<T extends DAO> {

    T create(T dao);
}
