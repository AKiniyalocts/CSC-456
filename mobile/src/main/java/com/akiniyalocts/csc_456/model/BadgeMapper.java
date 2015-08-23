package com.akiniyalocts.csc_456.model;

/**
 * Created by anthony on 8/22/15.
 */
public class BadgeMapper {
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
        else
            return "\uF262";
    }
}
