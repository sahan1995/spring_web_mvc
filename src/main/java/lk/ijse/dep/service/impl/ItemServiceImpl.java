package lk.ijse.dep.service.impl;

import lk.ijse.dep.dto.CustomerDTO;
import lk.ijse.dep.dto.ItemDTO;
import lk.ijse.dep.entity.Item;
import lk.ijse.dep.repository.ItemRepository;
import lk.ijse.dep.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<ItemDTO> getAllAItems() {
        List<Item> all =
                itemRepository.findAll();

        var dots = new ArrayList<ItemDTO>();

        for (Item item : all) {

            dots.add(new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand()));

        }

        return dots;
    }

    @Override
    public void addItem(String id, @RequestBody ItemDTO itemDTO) {

        if(!id.equals(itemDTO.getCode())){
            throw new RuntimeException("Not same");
        }

        itemRepository.save(new Item(itemDTO.getCode(),itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand()));


    }

    @Override
    public boolean updateItem(String id, @RequestBody ItemDTO itemDTO) {
        if(!id.equals(itemDTO.getCode())){
            throw new RuntimeException("Not same");
        }

        itemRepository.save(new Item(itemDTO.getCode(),itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand()));
        return true;

    }

    @Override
    public boolean removeItem(String id) {

        itemRepository.deleteById(id);
        return true;
    }

    @Override
    public ItemDTO findById(String id) {
        Optional<Item> byId =
                itemRepository.findById(id);

        Item item = byId.get();

        return new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand());

    }

    @Override
    public long itemCount() {

        return itemRepository.count();

    }
}
