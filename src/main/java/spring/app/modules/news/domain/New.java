package spring.app.modules.news.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.app.modules.commons.domain.ImageData;
import spring.app.modules.security.domain.User;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "news")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class New {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_new")
    private Long idNew;

    @Column(name = "name", nullable = false, unique = true, length = 130)
    private String name;

    @Column(name = "publish_date", nullable = false)
    private LocalDateTime publishDate;

    @Lob
    private String description;

    @OneToMany(mappedBy = "aNew", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ImageData> imageDataList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User createdBy;
}
