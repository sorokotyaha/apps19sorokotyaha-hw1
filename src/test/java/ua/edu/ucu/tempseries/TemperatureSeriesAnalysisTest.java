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




    @Test
    public void testmin() {
        double[] testSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(testSeries);

        double actualResult = seriesAnalysis.min();

        assertEquals(-5.0, actualResult, 0.00001);
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
    public void testmax() {
        double[] testSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(testSeries);

        double actualResult = seriesAnalysis.max();

        assertEquals(5, actualResult, 0.00001);
    }

    @Test
    public void findTempClosestToZero() {
        double[] testSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(testSeries);

        double actualResult = seriesAnalysis.max();

        assertEquals(1, actualResult, 0.00001);

    }

    @Test
    public void findTempClosestToValue() {
    }

    @Test
    public void findTempsLessThen() {
    }

    @Test
    public void findTempsGreaterThen() {
    }

    @Test
    public void summaryStatistics() {
    }

    @Test
    public void addTemps() {
    }
}
