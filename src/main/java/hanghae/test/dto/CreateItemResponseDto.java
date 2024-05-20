package hanghae.test.dto;

import hanghae.test.entity.Item;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class CreateItemResponseDto {

    private Long id;

    private String username;

    private String title;

    private String content;

    private int price;

    public static CreateItemResponseDto of(Item item) {
        return new CreateItemResponseDto(
                item.getId(),
                item.getUsername(),
                item.getTitle(),
                item.getContent(),
                item.getPrice()
        );
    }
}
