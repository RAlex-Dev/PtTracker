package com.rosalex.pttracker;

import com.rosalex.pttracker.entity.QAIRecord;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utilities {

    Map<Integer,Double> toChartData;

    // store month + variable (Albumin, Creatinine, etc...) and return it for graph rendering

    public Map<Integer, Double> getVariable(List<QAIRecord> qaiRecords, String type){
        Calendar calendar = Calendar.getInstance();

        toChartData = new HashMap<>();

        switch (type){
            case "Albumin":
                for(QAIRecord qaiRecord: qaiRecords){

                    toChartData.put(qaiRecord.getMonth().getValue(), qaiRecord.getAlbumin());
                }
                break;
            case "Creatinine":
                for(QAIRecord qaiRecord: qaiRecords){
                    toChartData.put(qaiRecord.getMonth().getValue(), qaiRecord.getCreatinine());
                }
                break;

            case "enPCR":
                for(QAIRecord qaiRecord: qaiRecords){
                    toChartData.put(qaiRecord.getMonth().getValue(), qaiRecord.getEnPCR());
                }
                break;
            case "Phosphorus":
                for(QAIRecord qaiRecord: qaiRecords){
                    toChartData.put(qaiRecord.getMonth().getValue(), qaiRecord.getPhosphorus());
                }
                break;
            case "IDWG":
                for(QAIRecord qaiRecord: qaiRecords){
                    toChartData.put(qaiRecord.getMonth().getValue(), qaiRecord.getIDWG());
                }
                break;
            case "Hemoglobin":
                for(QAIRecord qaiRecord: qaiRecords){
                    toChartData.put(qaiRecord.getMonth().getValue(), qaiRecord.getHemoglobin());
                }
                break;
        }

        return toChartData;
    }

}
