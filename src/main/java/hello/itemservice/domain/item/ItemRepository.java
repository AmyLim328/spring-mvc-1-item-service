package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>(); // static
    private static long sequence = 0L; // static
    // 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) {
        Item foundItem = findById(itemId);
        foundItem.setItemName(updateParam.getItemName());
        foundItem.setPrice(updateParam.getPrice());
        foundItem.setQuantity(updateParam.getQuantity());
//        updateParam.getId();
//        updateParam.setId();
        // => 혼란스러움 야기
        // 작은 프로젝트라서 이렇게 사용하지만
        // 실무였다면 itemName, Price, quantity 파라미터만 갖고 있는 itemParamDto 클래스 하나 더 만들어야 함
        // 개발자는 중복보다 명확성 중시
    }

    public void clearStore() {
        store.clear();
        // HashMap에 있는 데이터 다 날려버림
        // 테스트에서 사용하려고 만듦
    }

}
