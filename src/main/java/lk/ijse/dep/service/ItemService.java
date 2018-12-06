package lk.ijse.dep.service;

import lk.ijse.dep.dto.CustomerDTO;
import lk.ijse.dep.dto.ItemDTO;

import java.util.List;

public interface ItemService {

    List<ItemDTO> getAllAItems();


    void addItem(String id,ItemDTO itemDTO);

    boolean updateItem(String id,ItemDTO itemDTO);

    boolean removeItem(String id);

    ItemDTO findById(String id);

    long itemCount();

}
