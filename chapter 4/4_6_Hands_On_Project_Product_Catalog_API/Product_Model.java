
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @NotBlank private String name;
    @Positive private double price;
}
