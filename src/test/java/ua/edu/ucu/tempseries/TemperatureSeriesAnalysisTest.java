package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Ignore;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);        
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray(){
        double[] testSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(testSeries);
        //should throw exception here
        seriesAnalysis.deviation();
    }


    @Test
    public void testDeviationWithOneElementArray() {
        double[] testSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(testSeries);

        double actualResult = seriesAnalysis.deviation();

        assertEquals(0, actualResult, 0.00001);
    }

    @Test
    public void testDeviation(){
        double[] testSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(testSeries);

        double actualResult = seriesAnalysis.deviation();

        assertEquals(3.741657, actualResult, 0.00001);
    }

    @Test
    public void testMinWithOneElement() {
        // setup input data and expected result
        double[] testSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(testSeries);

        // call tested method
        double actualResult = seriesAnalysis.min();

        // compare expected result with actual result
        assertEquals(-1.0, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray(){
        double[] testSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(testSeries);
        //should throw exception here
        seriesAnalysis.min();
    }


    @Test
    public void testMin() {
        double[] testSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(testSeries);

        double actualResult = seriesAnalysis.min();

        assertEquals(-5.0, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray(){
        double[] testSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(testSeries);
        //should throw exception here
        seriesAnalysis.max();
    }

    @Test
    public void testMaxWithOneElement() {
        // setup input data and expected result
        double[] testSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(testSeries);

        // call tested method
        double actualResult = seriesAnalysis.max();

        // compare expected result with actual result
        assertEquals(-1.0, actualResult, 0.00001);
    }

    @Test
    public void testMax() {
        double[] testSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(testSeries);

        double actualResult = seriesAnalysis.max();

        assertEquals(5, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToZeroWithEmptyArray(){
        double[] testSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(testSeries);
        //should throw exception here
        seriesAnalysis.findTempClosestToZero();
    }

    @Test
    public void testFindTempClosestToZero() {
        double[] testSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(testSeries);

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(1, actualResult, 0.00001);

    }

    @Test
    public void testFindTempClosestToValue() {
        double[] testSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(testSeries);

        double actualResult = seriesAnalysis.findTempClosestToValue(10);

        assertEquals(5, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsLessThen() {
        double[] testSeries = {-20, 3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(testSeries);

        double[] actualResult = seriesAnalysis.findTempsLessThen(0);
        double[] expected = {-20, -5};

        assertArrayEquals(expected, actualResult, 0.00001);
    }

    @Test
    public void findTempsGreaterThen() {
        double[] testSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(testSeries);

        double[] actualResult = seriesAnalysis.findTempsGreaterThen(5);

        double[] expected = {5};

        assertArrayEquals(expected, actualResult, 0.00001);
    }

    @Test
    public void testsummaryStatistics() {
        double[] testSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(testSeries);

        double actualResult = seriesAnalysis.summaryStatistics().getAvgTemp();
        double expected = 1.0;
        assertEquals(expected, actualResult, 0.0001);
    }

    @Test
    public void testaddTemps() {
        double[] testSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(testSeries);

        double[] toAdd = {0, 1, 1, 2};
        double actualResult = seriesAnalysis.addTemps(toAdd);

        double expected = 8.0;

        assertEquals(expected, actualResult, 0.0001);
    }
}
