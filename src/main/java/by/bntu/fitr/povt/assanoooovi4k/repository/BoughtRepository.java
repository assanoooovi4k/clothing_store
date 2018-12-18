package by.bntu.fitr.povt.assanoooovi4k.repository;

import by.bntu.fitr.povt.assanoooovi4k.model.entity.BoughtItem;
import by.bntu.fitr.povt.assanoooovi4k.model.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BoughtRepository extends CrudRepository<BoughtItem, Long> {

    List<BoughtItem> findBoughtItemsByUser(User user);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO bought_item(user_id, item_id, status) VALUES (:userId, :itemId, :statusValue)", nativeQuery = true)
    void saveItem(@Param("userId")Long userId, @Param("itemId")Long itemId, @Param("statusValue")String statusValue);

    @Query(value = "SELECT * FROM bought_item JOIN user ON bought_item.user_id = user.id JOIN item on bought_item.item_id = item.id WHERE user_id=:userId", nativeQuery = true)
    List<BoughtItem> findByUserId(@Param("userId")Long userId);

}
