package hanghae.test.controller;

import hanghae.test.dto.*;
import hanghae.test.entity.Item;
import hanghae.test.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
@Slf4j
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<CreateItemResponseDto> createItem(@RequestBody CreateItemRequestDto dto) {
        CreateItemResponseDto response = itemService.createItem(dto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateItemResponseDto> updateItem(@PathVariable Long id, @RequestBody UpdateItemRequestDto dto) {
        UpdateItemResponseDto response = itemService.updateItem(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> deleteItem(@PathVariable Long id) {
        ResponseMessage response = itemService.deleteItem(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }
}