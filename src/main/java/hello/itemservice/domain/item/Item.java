package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// @Data // 핵심 도메인 모델에서 사용하기 위험 // 예측하지 못하게 동작할 수 있기 때문
        // 단순하게 data 왔다갔다할 때 사용하는 DTO일 경우에는 확인해보고 사용해도 괜찮다
@Getter @Setter // toString 등 추가적으로 필요하면 분리해서 사용하는 걸 추천
public class Item {

    private Long id;
    private String itemName;
    private Integer price; // null이 있다고 가정해서 int 대신 Integer 사용
    private Integer quantity; // null이 있다고 가정해서 int 대신 Integer 사용

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
