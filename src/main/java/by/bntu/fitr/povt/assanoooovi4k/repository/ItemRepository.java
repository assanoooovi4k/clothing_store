package by.bntu.fitr.povt.assanoooovi4k.repository;

import by.bntu.fitr.povt.assanoooovi4k.domain.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {
    List<Item> findByName(String name);
}
