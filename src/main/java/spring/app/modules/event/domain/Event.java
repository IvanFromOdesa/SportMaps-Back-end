package spring.app.modules.event.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.app.modules.commons.domain.ImageData;
import spring.app.modules.commons.domain.SportType;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "events")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_event")
    private Long idEvent;

    @Column(name = "name", nullable = false, unique = true, length = 50)
    private String name;

    @Column(name = "event_date", nullable = false, length = 50)
    private LocalDateTime eventDate;

    @Lob
    private String description;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "sport_type")
    private SportType sportType;

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ImageData> imageDataList;
}
