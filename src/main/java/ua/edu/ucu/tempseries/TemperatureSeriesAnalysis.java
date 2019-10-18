package ua.edu.ucu.tempseries;

import java.lang.Math;
import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    private double[] temperatures;

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.temperatures = temperatureSeries;
    }

    public void TemperatureSeriesAnalysis(double[] temperatureSeries) {
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] < -273.0) {
                throw new InputMismatchException();
            }
        }
    }



    public double average() {
        int count = 0;
        double summ = 0;
        for (int i = 0; i < this.temperatures.length; i++){
            summ += this.temperatures[i];
            count += 1;
        }
        return summ / count;
    }

    public double deviation() {
        double av = this.average();
        double summ = 0;
        for (int i = 0; i < this.temperatures.length; i++) {
            summ += Math.pow(this.temperatures[i] - av, 2);
        }
        return Math.sqrt(summ / this.temperatures.length);
    }

    public double min() {

        double min = this.temperatures[0];
        for (int i = 1; i < this.temperatures.length; i++){
            if (this.temperatures[i] < min){
                min = this.temperatures[i];
            }
        }
        return min;
    }

    public double max() {
        double maxx = this.temperatures[0];
        for (int i = 1; i < this.temperatures.length; i++){
            if (this.temperatures[i] > maxx){
                maxx = this.temperatures[i];
            }
        }
        return maxx;
    }

    public double findTempClosestToZero() {
        double minDiff = Math.abs(this.temperatures[0]);
        double minTemp = this.temperatures[0];
        for (int i = 1; i < this.temperatures.length; i++){
            if (minDiff > Math.abs(this.temperatures[i])){
                minTemp = Math.abs(this.temperatures[i]);
            }
        }
        return minTemp;
    }

    public double findTempClosestToValue(double tempValue) {
        double minDiff = Math.abs(tempValue - this.temperatures[0]);
        double minTemp = this.temperatures[0];
        for (int i = 1; i < this.temperatures.length; i++){
            if (minDiff > Math.abs(tempValue - this.temperatures[i])){
                minTemp = this.temperatures[i];
            }
        }
        return minTemp;
    }

    public double[] findTempsLessThen(double tempValue) {
        int count = 0;

        for (int j = 0; j < this.temperatures.length; j++){
            if (this.temperatures[j] < tempValue){
                count += 1;
            }
        }

        double[] less = new double[count];
        int z = 0;
        for (int i = 0; i < this.temperatures.length; i++){
            if (this.temperatures[i] < tempValue && z < count){
                less[z] = this.temperatures[i];
                z += 1;
            }
        }
        return less;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        int count = 0;
        for (int j = 0; j < this.temperatures.length; j++){
            if (this.temperatures[j] >= tempValue){
                count += 1;
            }
        }
        double[] greater = new double[count];
        int z = 0;
        for (int i = 0; i < this.temperatures.length; i++){
            if (this.temperatures[i] >= tempValue && z < count){
                greater[z] = this.temperatures[i];
                z += 1;
            }
        }
        return greater;
    }

    public TempSummaryStatistics summaryStatistics() {
        return new TempSummaryStatistics(this.average(), this.deviation(),
                this.min(), this.max());
    }

    public int addTemps(double... temps) {
        double[] addedTemp = Arrays.copyOf(this.temperatures, this.temperatures.length + temps.length);
        int t = 0;
        for (int i = this.temperatures.length; i < addedTemp.length; i++){
            addedTemp[i] = temps[t];
            t++;
        }
        this.temperatures = addedTemp;
        return t;
    }

}

