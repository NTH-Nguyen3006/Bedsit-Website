package com.example.ahihi.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    short status;

    @Column(length = 50, nullable = false)
    String roomType;

    @Column(columnDefinition = "text")
    String decription;

    enum Status {
        Available, Rent, Repair
    }

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    Set<RoomDetails> roomDetails;
}
