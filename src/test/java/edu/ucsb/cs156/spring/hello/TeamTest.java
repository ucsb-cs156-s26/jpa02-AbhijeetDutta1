package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_same_object_returns_true() {
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_same_values_returns_true() {
        Team other = new Team("test-team");
        assertEquals(team, other);
    }

    @Test
    public void equals_different_class_returns_false() {
        assertFalse(team.equals("test-team"));
    }

    @Test
    public void equals_same_name_different_members_returns_false() {
        Team other = new Team("test-team");
        other.addMember("alice");

        assertFalse(team.equals(other));
    }

    @Test
    public void equals_different_name_same_members_returns_false() {
        team.addMember("alice");
        Team other = new Team("different-team");
        other.addMember("alice");

        assertFalse(team.equals(other));
    }

    @Test
    public void hashCode_returns_expected_value_for_given_content() {
        Team t = new Team();
        t.setName("foo");
        t.addMember("bar");

        int expectedResult = 130294;
        assertEquals(expectedResult, t.hashCode());
    }

   // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
   // 100% mutation coverage (all mutants timed out or killed)

}
