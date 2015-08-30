package com.akiniyalocts.csc_456;

import java.util.Date;
import java.util.Random;

/**
 * Created by anthony on 8/27/15.
 */
public class Utils {


    public static Date getDateFromString(String date){
        return new Date(Date.parse(date));

    }

    public static String getRandomMaterialColor(){
        String[] colors =
                {
                        "#03A9F4", "#F44336", "#E91E63", "#9C27B0", "#673AB7", "#3F51B5", "#2196F3", "#00BCD4",
                        "#009688", "#4CAF50", "#8BC34A", "#CDDC39", "#FFEB3B", "#FFC107", "#FF9800", "#FF5722",
                        "#607D8B", "#9E9E9E"
                };

        return colors[new Random().nextInt(colors.length)];
    }

    public static class BadgeMapper {
        public static String get(String glyphName){
            if(glyphName.equals("cloud"))
                return "\uF21F";
            else if(glyphName.equals("local_activity"))
                return "\uF1DF";
            else if(glyphName.equals("snooze"))
                return "\uF32C";
            else if(glyphName.equals("view_quilt"))
                return "\uF322";
            else if(glyphName.equals("people"))
                return "\uF209";
            else if(glyphName.equals("lens"))
                return "\uF26D";
            else if(glyphName.equals("cloud_off"))
                return "\uF21B";
            else if(glyphName.equals("devices"))
                return "\uF295";
            else if(glyphName.equals("check"))
                return "\uF26B";
            else if(glyphName.equals("android"))
                return "\uF33B";
            else if(glyphName.equals("present_to_all"))
                return "\uF3E4";
            else if(glyphName.equals("mood"))
                return "\uF214";
            else
                return "\uF262";
        }
    }
}
