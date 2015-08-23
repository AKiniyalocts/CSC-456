package com.akiniyalocts.csc_456.model;

import java.util.Random;

/**
 * Created by anthony on 8/22/15.
 */
public class Constants {

    public static String getRandomMaterialColor(){
        String[] colors =
                {
                        "#03A9F4", "#F44336", "#E91E63", "#9C27B0", "#673AB7", "#3F51B5", "#2196F3", "#00BCD4",
                        "#009688", "#4CAF50", "#8BC34A", "#CDDC39", "#FFEB3B", "#FFC107", "#FF9800", "#FF5722",
                        "#607D8B", "#9E9E9E"
                };

        return colors[new Random().nextInt(colors.length)];
    }
}
