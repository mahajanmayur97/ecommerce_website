package dev.mayur.productcatalogue.inheritancedemo.singletable;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("st_ur")
public interface UserRepository extends JpaRepository<User,Long > {
    @Override
    <S extends User> S save(S entity);

    @Override
    <S extends User> List<S> findAll(Example<S> example);
}
