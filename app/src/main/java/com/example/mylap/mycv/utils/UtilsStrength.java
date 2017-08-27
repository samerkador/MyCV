package com.example.mylap.mycv.utils;

import com.example.mylap.mycv.R;
import com.example.mylap.mycv.model.Strength;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yalantis
 */
public class UtilsStrength {
    public static final List<Strength> strengths = new ArrayList<>();

    static {
        strengths.add(new Strength(R.drawable.lasso_tool_mycv, "ANASTASIA", R.color.sienna, "Sport"));
        strengths.add(new Strength(R.drawable.lasso_tool_mycv, "IRENE", R.color.saffron, "Travelling"));
        strengths.add(new Strength(R.drawable.lasso_tool_mycv, "KATE", R.color.green, "Sales"));
        strengths.add(new Strength(R.drawable.lasso_tool_mycv, "PAUL", R.color.pink, "Android"));
        strengths.add(new Strength(R.drawable.lasso_tool_mycv, "DARIA", R.color.orange, "Design"));
        strengths.add(new Strength(R.drawable.lasso_tool_mycv, "KIRILL", R.color.saffron, "Development"));
    }
}
