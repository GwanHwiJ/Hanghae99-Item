package hanghae.test.service;

import hanghae.test.dto.*;
import hanghae.test.entity.Item;
import hanghae.test.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ItemService {

    private final ItemRepository itemRepository;

    public CreateItemResponseDto createItem(CreateItemRequestDto dto) {
        Item encoding = new Item(dto.getUsername(), dto.getTitle(), dto.getContent(), dto.getPrice());

        Item item = itemRepository.save(encoding);

        return CreateItemResponseDto.of(item);
    }

    public UpdateItemResponseDto updateItem(Long id, UpdateItemRequestDto dto) {

        Item item = itemRepository.findById(id).orElseThrow();
        item.update(dto.getTitle(), dto.getContent(), dto.getPrice(), dto.getUsername());

        return UpdateItemResponseDto.of(item);
    }

    public ResponseMessage deleteItem(Long id) {
        Item item = itemRepository.findById(id).orElseThrow();

        itemRepository.delete(item);
        return new ResponseMessage("삭제완료");
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

}
