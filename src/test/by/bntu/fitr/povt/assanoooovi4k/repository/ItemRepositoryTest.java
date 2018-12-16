package by.bntu.fitr.povt.assanoooovi4k.repository;

import by.bntu.fitr.povt.assanoooovi4k.model.entity.Item;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ItemRepositoryTest {

    @Mock
    private ItemRepository itemRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findByName() {
        when(itemRepository.findByName("ya dolbaeb"))
                .thenReturn(Collections.singletonList(new Item("ya dolbaeb", 0)));
        assertEquals(Collections.singletonList(new Item("ya dolbaeb", 0)), itemRepository.findByName("ya dolbaeb"));
    }


}