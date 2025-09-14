package tacos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // 自动生成 id值
    private Long id; // 惟一标识符

    private Date createdAt = new Date(); // 创建日期和时间

    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    @Size(min = 1, message = "You must choose at least 1 ingredient")
    @ManyToMany // 声明 Taco 及其相关 Ingredient 列表之间的关系
    //一个 Taco 可以有很多 Ingredient，一个 Ingredient 可以是很多 Taco 的一部分。
    private List<Ingredient> ingredients;

    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }
}
