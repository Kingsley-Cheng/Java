package tacos;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Entity: 声明JPA实体
// 使用所有属性初始化值创建 Ingredient 对象。
// @AllArgsConstructor
// JPA 要求实体有一个无参构造函数。
// 要是不想使用它，可以通过将 access 属性设置为AccessLevel.PRIVATE 来将其设置为私有。
// 因为必须设置 final 属性，所以还要将 force 属性设置为 true，这将导致 Lombok 生成的构造函数，依据属性类型的不同会将它们设置为 null、0 或者 false。
// @NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public class Ingredient {

    @Id
    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
