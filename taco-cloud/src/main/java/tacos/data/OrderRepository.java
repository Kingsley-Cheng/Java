package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.TacoOrder;

// 第一个参数是要由该存储库持久化的对象, 二个参数是持久化对象的ID字段的类型
public interface OrderRepository extends CrudRepository<TacoOrder, Long> {}
