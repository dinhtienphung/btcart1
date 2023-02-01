package mvc.repository;

import mvc.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends CrudRepository<OrderDetailEntity, Integer> {
    @Query(value = "select * from orderdetail where orderid = ?1", nativeQuery = true)
    List<OrderDetailEntity> getorderDetailByOrderId(int id);

}
