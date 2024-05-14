package book.com.bookstore.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "product")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;

    private String sku;

    private String name;

    private String description;

    @Column(name = "unit_price")
    private String unitPrice;

    @Column(name = "image_url")
    private String imageUrl;

    private boolean active;

    @Column(name = "units_in_stock")
    private int unitsInStock;

    @CreationTimestamp
    @Column(name = "date_created")
    private Date dateCreated;

    @UpdateTimestamp
    @Column(name = "last_updated")
    private Date lastUpdated;
}
