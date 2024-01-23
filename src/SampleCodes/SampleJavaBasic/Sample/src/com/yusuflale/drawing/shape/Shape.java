package com.yusuflale.drawing.shape;

import com.yusuflale.drawing.Color;

import java.io.Serial;
import java.io.Serializable;

public abstract class Shape implements Serializable {
    @Serial
    private static final long serialVersionUID = -1L;

    protected Color backgroundColor;
    protected Color foregroundColor;

    protected Shape()
    {
        backgroundColor = Color.WHITE;
        foregroundColor = Color.BLACK;
    }

    protected Shape(Color backgroundColor, Color foregroundColor)
    {
        this.backgroundColor = backgroundColor;
        this.foregroundColor = foregroundColor;
    }

    //...
}