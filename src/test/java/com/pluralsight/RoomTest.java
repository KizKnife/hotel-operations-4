package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void checkIn_setsRoomToOccupiedAndDirty() {

        // arrange
        Room room = new Room(2, 100, false, false);

        // act
        room.checkIn();

        // assert
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());

    }

    @Test
    void checkOut_setsRoomToNotOccupiedAndDirty() {

        // arrange
        Room room = new Room(2, 100, true, true);

        //act
        room.checkOut();

        // assert
        assertFalse(room.isOccupied());
        assertTrue(room.isDirty());

    }

    @Test
    void cleanRoom_setsRoomToNotDirty() {

        // arrange
        Room room = new Room(2, 100, true, true);

        //act
        room.cleanRoom();

        // assert
        assertFalse(room.isDirty());

    }
}