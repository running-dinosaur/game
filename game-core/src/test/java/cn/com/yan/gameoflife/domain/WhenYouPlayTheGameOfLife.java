package cn.com.yan.gameoflife.domain;

import org.junit.Test;

import cn.com.yan.gameoflife.domain.Universe;

import static cn.com.yan.gameoflife.domain.Universe.seededWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class WhenYouPlayTheGameOfLife {

    private final String NEW_LINE = System.getProperty("line.separator");

    @Test
    public void aDeadCellWithNoNeighboursShouldRemainDeadInTheNextGeneration() {
        String initialGrid = "..." + NEW_LINE +
                "..." + NEW_LINE +
                "...";

        String expectedNextGrid = "..." + NEW_LINE +
                "..." + NEW_LINE +
                "..." + NEW_LINE + "";

        Universe theUniverse = new Universe(seededWith(initialGrid));
        theUniverse.createNextGeneration();

        String nextGrid = theUniverse.getGrid();
        assertThat(nextGrid, is(expectedNextGrid));
    }

    @Test
    public void aDeadCellWithOneLiveNeighbourShouldRemainDeadInTheNextGeneration() {
        String initialGrid = "..." + NEW_LINE +
                ".*." + NEW_LINE +
                "...";

        String expectedNextGrid = "..." + NEW_LINE +
                "..." + NEW_LINE +
                "..." + NEW_LINE + "";

        Universe theUniverse = new Universe(seededWith(initialGrid));
        theUniverse.createNextGeneration();

        String nextGrid = theUniverse.getGrid();
        assertThat(nextGrid, is(expectedNextGrid));
    }

    @Test
    public void liveCellaWith2or3iveNeighbourShouldRemainAliveInTheNextGeneration() {
        String initialGrid = "**." + NEW_LINE +
                "**." + NEW_LINE +
                "...";

        String expectedNextGrid = "**." + NEW_LINE +
                "**." + NEW_LINE +
                "..." + NEW_LINE + "";

        Universe theUniverse = new Universe(seededWith(initialGrid));
        theUniverse.createNextGeneration();

        String nextGrid = theUniverse.getGrid();
        assertThat(nextGrid, is(expectedNextGrid));
    }

    @Test
    public void aLiveCellWithExactlyTwoLiveNeighbourShouldRemainAliveInTheNextGeneration() {
        String initialGrid = "..." + NEW_LINE +
                "***" + NEW_LINE +
                "..." + NEW_LINE + "";

        String expectedNextGrid = ".*." + NEW_LINE +
                ".*." + NEW_LINE +
                ".*." + NEW_LINE + "";

        Universe theUniverse = new Universe(seededWith(initialGrid));
        theUniverse.createNextGeneration();

        String nextGrid = theUniverse.getGrid();
        assertThat(nextGrid, is(expectedNextGrid));
    }

    @Test
    public void aCellWithNoNeighboursShouldDieInTheNextGeneration() {
        String initialGrid = "..." + NEW_LINE +
                "..." + NEW_LINE +
                "..." + NEW_LINE + "";

        String expectedNextGrid = "..." + NEW_LINE +
                "..." + NEW_LINE +
                "..." + NEW_LINE + "";

        Universe theUniverse = new Universe(seededWith(initialGrid));
        theUniverse.createNextGeneration();

        String nextGrid = theUniverse.getGrid();
        assertThat(nextGrid, is(expectedNextGrid));
    }
}
