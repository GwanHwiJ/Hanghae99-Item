package hanghae.test.dto;

import hanghae.test.entity.Item;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UpdateItemResponseDto {

    private Long id;

    private String title;

    private String content;

    private int price;

    private String username;

    public static UpdateItemResponseDto of(Item item) {
        return new UpdateItemResponseDto(
                item.getId(),
                item.getTitle(),
                item.getContent(),
                item.getPrice(),
                item.getUsername()
        );
    }
}
