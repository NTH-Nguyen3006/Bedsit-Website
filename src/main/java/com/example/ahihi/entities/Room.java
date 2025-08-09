package com.example.ahihi.entities;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "rooms")
@JsonFormat
@EqualsAndHashCode(exclude = "roomDetails")
public class Room {
    @Id
    @Column(name = "roomId", length = 7)
    String id;
    double area;
    double rentPrice;

    @Enumerated(EnumType.ORDINAL)
    Status status;

    @Column(length = 50, nullable = false, columnDefinition = "NVARCHAR(50)")
    String roomType;

    @Column(columnDefinition = "NVARCHAR(MAX)")
    String decription;

    @CreatedDate
    @Column(updatable = false)
    LocalDateTime createAt;

    @LastModifiedDate
    LocalDateTime updatedAt;

    public enum Status {
        Available("Phòng Trống"),
        Rent("Đã Thuê"),
        Repair("Đang Bảo Trì");

        String content;

        Status(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }
    }

    @ToString.Exclude
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    Set<RoomDetails> roomDetails;

}
