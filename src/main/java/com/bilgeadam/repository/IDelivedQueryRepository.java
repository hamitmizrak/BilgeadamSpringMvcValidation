package com.bilgeadam.repository;
import com.bilgeadam.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IDelivedQueryRepository extends JpaRepository<PersonEntity,Long> {
    //delivedQuery normalde @query yazıyoruz ancak burada yazmıyoruz. ve hemen aşağıdaki @Query kendi oluşturmasıdır.
    //@Query("select c from PersonEntity c where c.personName= :personName")

    //yazım kuralları:
    // başlangıçta ==> find,delete,count,get verebilirsin
    // sonra by yazmak zorundasın
    // by sonra Entity alakalı nesne değişkenleri gelir


    List<PersonEntity> findByPersonName(String personName);
    List<PersonEntity> findByPersonNameEquals(String personName);
    List<PersonEntity> findByPersonNameLike(String personName);
    List<PersonEntity> findByPersonNameStartingWith(String personName);
    List<PersonEntity> findByPersonNameEndsWith(String personName);

    List<PersonEntity> findByPersonPrice  (double personPrice);
    List<PersonEntity> findByPersonPriceBetween  (double personPriceMin, double personPriceMax);
    List<PersonEntity> findByPersonPriceGreaterThan  (double personPrice);

    //başlangıcı x olan veya verdiğin sayıdan daha az olan
    List<PersonEntity> findByPersonNameStartingWithOrPersonPriceLessThan  (String personName,double personPrice);
}
