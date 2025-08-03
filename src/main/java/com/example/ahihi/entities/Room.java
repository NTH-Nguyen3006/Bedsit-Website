package com.example.ahihi.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
public class Room {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;
    double area;
    short status;

    @Column(length = 50, nullable = false)
    String roomType;

    @Column(columnDefinition = "text")
    String decription;

    enum Status {
        Available, Rent, Repair
    }

    @OneToMany(mappedBy = "room")
    private Set<RoomDetails> roomDetails;
}
