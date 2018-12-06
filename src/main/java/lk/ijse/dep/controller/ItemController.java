package lk.ijse.dep.controller;

import lk.ijse.dep.dto.ItemDTO;
import lk.ijse.dep.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/items")
public class ItemController {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public String handleMyExeception(RuntimeException ex){
        ex.printStackTrace();
        return ex.getMessage();
    }

    @Autowired
    private ItemService itemService;



    @GetMapping
    public List<ItemDTO> getAllItems(){
        return itemService.getAllAItems();
    }

    @PutMapping(value = "/{code}")
    public void saveItem(@PathVariable("code") String id,@RequestBody ItemDTO itemDTO){
        itemService.addItem(id,itemDTO);

    }

    @PostMapping(value = "/{code}")
    public boolean updateItem(@PathVariable("code") String id,@RequestBody ItemDTO itemDTO){
        return  itemService.updateItem(id,itemDTO);

    }


    @DeleteMapping(value = "/{code}")
    public boolean deleteItem(@PathVariable("code") String id){
        return itemService.removeItem(id);

    }

    @GetMapping(value = "/{code}")
    public ItemDTO findById(@PathVariable("code") String code){
        return itemService.findById(code);
    }

    @GetMapping(params = {"action=count"})
    public long itemCount(){
        return itemService.itemCount();
    }

}
