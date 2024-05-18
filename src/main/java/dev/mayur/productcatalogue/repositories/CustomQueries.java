package dev.mayur.productcatalogue.repositories;

public interface CustomQueries {
    String FIND_ALL_BY_TITLE = "select * from product where title = :mayur";
}
