package hanghae.test.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UpdateItemRequestDto {

    private String title;

    private String content;

    private int price;

    private String username;
}
